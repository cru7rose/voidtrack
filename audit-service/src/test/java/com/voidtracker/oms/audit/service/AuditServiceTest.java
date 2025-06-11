package com.voidtracker.oms.audit.service;

import com.voidtracker.oms.commons.dto.AuditDto;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.assertj.core.api.Assertions.assertThat;

class AuditServiceTest {
    @Test
    void registerAndGetEvent() {
        AuditService service = new AuditService();
        AuditDto event = new AuditDto("evt1", "Order", "order1", "CREATE", "user1", Instant.now(), "details");
        service.registerEvent(event);
        assertThat(service.getEvent("evt1")).isPresent();
    }
}
