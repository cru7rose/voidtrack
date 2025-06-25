package com.voidtracker.oms.audit.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public record AuditDto(
    String auditId,
    String entityType,
    String entityId,
    String action,
    String userId,
    OffsetDateTime timestamp,
    Map<String, Object> details
) {

}
