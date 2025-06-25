package com.voidtracker.oms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderStatusHistoryDto {
    private String orderId;
    private List<StatusChange> history;

    @Data
    @NoArgsConstructor
    public static class StatusChange {
        private String status;
        private String timestamp;
        public StatusChange(String status, String timestamp) {
            this.status = status;
            this.timestamp = timestamp;
        }
    }
}
