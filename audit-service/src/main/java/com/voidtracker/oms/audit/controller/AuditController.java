package com.voidtracker.oms.audit.controller;

import com.voidtracker.oms.commons.dto.AuditDto;
import com.voidtracker.oms.audit.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
@Validated
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public ResponseEntity<AuditDto> registerEvent(@Valid @RequestBody AuditDto auditDto) {
        AuditDto created = auditService.registerEvent(auditDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDto> getEvent(@PathVariable String id) {
        return auditService.getEvent(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<AuditDto>> listEvents() {
        return ResponseEntity.ok(auditService.listEvents());
    }
}
