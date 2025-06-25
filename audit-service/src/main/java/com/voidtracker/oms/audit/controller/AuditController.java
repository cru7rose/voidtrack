package com.voidtracker.oms.audit.controller;

import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import org.everit.json.schema.ValidationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.*;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/audit")
@Tag(name = "Audit Events", description = "Audit event logging and query API")
public class AuditController {
    private final AuditService auditService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final String auditSchema;
    private final ObjectMapper objectMapper;

    public AuditController(AuditService auditService, JsonSchemaValidator jsonSchemaValidator, ObjectMapper objectMapper) throws Exception {
        this.auditService = auditService;
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.objectMapper = objectMapper;
        var resource = new ClassPathResource("schemas/json/Audit_v1.json");
        this.auditSchema = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    @GetMapping
    @Operation(summary = "List all audit events", responses = {
        @ApiResponse(responseCode = "200", description = "List of audit events", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuditDto.class)))
    })
    public List<AuditDto> listAuditEvents() {
        return auditService.listAuditEvents();
    }

    @GetMapping("/{auditId}")
    @Operation(summary = "Get audit event details", responses = {
        @ApiResponse(responseCode = "200", description = "Audit event details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuditDto.class)))
    })
    public AuditDto getAuditEvent(@PathVariable String auditId) {
        return auditService.getAuditEvent(auditId);
    }

    @PostMapping
    @Operation(summary = "Log new audit event", responses = {
        @ApiResponse(responseCode = "200", description = "Created audit event", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuditDto.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.voidtracker.oms.commons.dto.ApiErrorDto.class)))
    })
    public ResponseEntity<?> createAuditEvent(@RequestBody String auditDtoJson) throws Exception {
        try {
            jsonSchemaValidator.validate(auditDtoJson, auditSchema);
            AuditDto auditDto = objectMapper.readValue(auditDtoJson, AuditDto.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(auditService.createAuditEvent(auditDto));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("errorCode", "VALIDATION_ERROR", "message", e.getMessage())
            );
        }
    }
}
