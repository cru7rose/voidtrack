package com.voidtracker.oms.audit.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public class ExampleAuditDtoFactory {
    public static AuditDto createExampleAuditDto() {
        return new AuditDto(
            "audit-1",
            "Order",
            "a1b2c3d4-e5f6-7890-1234-567890abcdef",
            "STATUS_CHANGE",
            "john_doe",
            OffsetDateTime.parse("2024-06-10T08:10:00Z"),
            Map.of("from", "PICKUP", "to", "LOAD")
        );
    }
}
