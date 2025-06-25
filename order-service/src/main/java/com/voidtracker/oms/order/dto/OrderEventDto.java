package com.voidtracker.oms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderEventDto {
    private String eventId;
    private String orderId;
    private String type;
    private String statusFrom;
    private String statusTo;
    private String timestamp;
    private String userId;
}
