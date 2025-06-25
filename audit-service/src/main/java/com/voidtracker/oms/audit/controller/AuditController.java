package com.voidtracker.oms.audit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.dto.ApiErrorDto;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/audit")
@Tag(name = "Audit Events", description = "Audit event logging and query API")
public class AuditController {

    private final AuditService auditService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ObjectMapper objectMapper;

    // Konstruktor jest teraz znacznie prostszy
    public AuditController(AuditService auditService, JsonSchemaValidator jsonSchemaValidator, ObjectMapper objectMapper) {
        this.auditService = auditService;
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.objectMapper = objectMapper;
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
            @ApiResponse(responseCode = "201", description = "Created audit event", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuditDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDto.class)))
    })
    public ResponseEntity<?> createAuditEvent(@RequestBody String auditDtoJson) {
        // Używamy try-with-resources, aby strumień został automatycznie zamknięty
        try (InputStream schemaStream = new ClassPathResource("schemas/json/Audit_v1.json").getInputStream()) {
            // Walidacja z użyciem nowej, poprawnej metody
            jsonSchemaValidator.validate(auditDtoJson, schemaStream);

            // Dalsza logika pozostaje bez zmian
            AuditDto auditDto = objectMapper.readValue(auditDtoJson, AuditDto.class);
            AuditDto createdAudit = auditService.createAuditEvent(auditDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAudit);
        } catch (Exception e) {
            // Łapiemy generyczny wyjątek (np. błąd odczytu pliku lub błąd walidacji)
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}