package com.voidtracker.oms.audit.service;

import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.repository.AuditRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public List<AuditDto> listAuditEvents() {
        return auditRepository.findAll();
    }

    public AuditDto getAuditEvent(String auditId) {
        return auditRepository.findById(auditId).orElse(null);
    }

    public AuditDto createAuditEvent(AuditDto event) {
        return auditRepository.save(event);
    }
}
