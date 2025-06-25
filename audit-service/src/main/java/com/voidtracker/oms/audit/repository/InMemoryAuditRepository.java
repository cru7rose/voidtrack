package com.voidtracker.oms.audit.repository;

import com.voidtracker.oms.audit.dto.AuditDto;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryAuditRepository implements AuditRepository {
    private final Map<String, AuditDto> events = new HashMap<>();

    @Override
    public List<AuditDto> findAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Optional<AuditDto> findById(String auditId) {
        return Optional.ofNullable(events.get(auditId));
    }

    @Override
    public AuditDto save(AuditDto event) {
        events.put(event.auditId(), event);
        return event;
    }

    @Override
    public void deleteById(String id) {
        events.remove(id);
    }
}
