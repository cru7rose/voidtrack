package com.voidtracker.oms.audit.service;

import com.voidtracker.oms.commons.dto.AuditDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuditService {
    private final Map<String, AuditDto> events = new HashMap<>();

    public AuditDto registerEvent(AuditDto auditDto) {
        events.put(auditDto.getId(), auditDto);
        return auditDto;
    }

    public Optional<AuditDto> getEvent(String id) {
        return Optional.ofNullable(events.get(id));
    }

    public List<AuditDto> listEvents() {
        return new ArrayList<>(events.values());
    }
}
