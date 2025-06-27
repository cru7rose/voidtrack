package com.voidtracker.oms.audit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.dto.ApiErrorDto;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.everit.json.schema.ValidationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audit")
@Tag(name = "Audit Events", description = "Audit event logging and query API")
public class AuditController {

    private final AuditService auditService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ObjectMapper objectMapper;
    private final String auditSchema;

    public AuditController(AuditService auditService, JsonSchemaValidator jsonSchemaValidator, ObjectMapper objectMapper) throws Exception {
        this.auditService = auditService;
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.objectMapper = objectMapper;
        // Wczytujemy schemat raz, podczas tworzenia kontrolera
        var resource = new ClassPathResource("schemas/json/Audit_v1.json");
        this.auditSchema = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    @GetMapping
    @Operation(summary = "List all audit events")
    public List<AuditDto> listAuditEvents() {
        return auditService.listAuditEvents();
    }

    @GetMapping("/{auditId}")
    @Operation(summary = "Get audit event details")
    public AuditDto getAuditEvent(@PathVariable String auditId) {
        return auditService.getAuditEvent(auditId);
    }

    @PostMapping
    @Operation(summary = "Log new audit event")
    public ResponseEntity<?> createAuditEvent(@RequestBody String auditDtoJson) {
        try {
            jsonSchemaValidator.validate(auditDtoJson, auditSchema);
            AuditDto auditDto = objectMapper.readValue(auditDtoJson, AuditDto.class);
            AuditDto createdAudit = auditService.createAuditEvent(auditDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAudit);
        } catch (ValidationException e) {
            String errorDetails = e.getAllMessages().stream().collect(Collectors.joining(", "));
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), errorDetails);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception e) {
            ApiErrorDto error = new ApiErrorDto("REQUEST_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}