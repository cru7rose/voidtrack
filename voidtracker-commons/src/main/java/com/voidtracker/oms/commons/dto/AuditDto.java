package com.voidtracker.oms.commons.dto;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO reprezentujący zdarzenie audytowe w OMS.
 * Immutable, zgodny z katalogiem DTO projektu.
 */
public class AuditDto {
    @NotBlank
    private final String id;

    @NotBlank
    private final String entityType; // Np. Order, User, ePoD

    @NotBlank
    private final String entityId;

    @NotBlank
    private final String action; // CREATE, UPDATE, STATUS_CHANGE, ...

    @NotBlank
    private final String userId;

    @NotNull
    private final Instant timestamp;

    @NotBlank
    private final String details; // JSON string z detalami

    public AuditDto(String id, String entityType, String entityId, String action, String userId, Instant timestamp, String details) {
        this.id = id;
        this.entityType = entityType;
        this.entityId = entityId;
        this.action = action;
        this.userId = userId;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getId() { return id; }
    public String getEntityType() { return entityType; }
    public String getEntityId() { return entityId; }
    public String getAction() { return action; }
    public String getUserId() { return userId; }
    public Instant getTimestamp() { return timestamp; }
    public String getDetails() { return details; }
}
