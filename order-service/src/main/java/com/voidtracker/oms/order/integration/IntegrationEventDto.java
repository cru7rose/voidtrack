package com.voidtracker.oms.order.integration;

import lombok.Data;

@Data
public class IntegrationEventDto {
    private String eventId;
    private String eventType;
    private String payload;
    private String sourceSystem;
    private String timestamp;
}
