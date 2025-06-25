package com.voidtracker.oms.audit.service;

import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.repository.AuditRepository;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

class AuditServiceTest {
    static class InMemoryAuditRepository implements AuditRepository {
        private final Map<String, AuditDto> events = new HashMap<>();
        @Override
        public java.util.List<AuditDto> findAll() { return new java.util.ArrayList<>(events.values()); }
        @Override
        public Optional<AuditDto> findById(String id) { return Optional.ofNullable(events.get(id)); }
        @Override
        public AuditDto save(AuditDto event) { events.put(event.auditId(), event); return event; }
        @Override
        public void deleteById(String id) { events.remove(id); }
    }

    @Test
    void registerAndGetEvent() {
        AuditRepository repo = new InMemoryAuditRepository();
        AuditService service = new AuditService(repo);
        AuditDto event = new AuditDto(
            "evt1",
            "Order",
            "order1",
            "CREATE",
            "user1",
            OffsetDateTime.now(),
            Map.of("details", "something")
        );
        service.createAuditEvent(event);
        assertThat(service.getAuditEvent("evt1")).isNotNull();
    }
}
