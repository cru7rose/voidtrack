package com.voidtracker.oms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

/**
 * DTO for order status change requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusChangeRequestDto {
    private String status;
    private Instant timestamp;
    private String scannedBy;
}
