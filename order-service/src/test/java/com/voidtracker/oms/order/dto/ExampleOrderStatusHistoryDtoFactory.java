package com.voidtracker.oms.order.dto;

import java.util.Arrays;

public class ExampleOrderStatusHistoryDtoFactory {
    public static OrderStatusHistoryDto createExampleOrderStatusHistoryDto() {
        OrderStatusHistoryDto hist = new OrderStatusHistoryDto();
        hist.setOrderId("a1b2c3d4-e5f6-7890-1234-567890abcdef");
        OrderStatusHistoryDto.StatusChange s1 = new OrderStatusHistoryDto.StatusChange();
        s1.setStatus("PENDING");
        s1.setTimestamp("2024-06-10T07:30:00Z");
        OrderStatusHistoryDto.StatusChange s2 = new OrderStatusHistoryDto.StatusChange();
        s2.setStatus("NEW");
        s2.setTimestamp("2024-06-10T07:35:00Z");
        OrderStatusHistoryDto.StatusChange s3 = new OrderStatusHistoryDto.StatusChange();
        s3.setStatus("PICKUP");
        s3.setTimestamp("2024-06-10T08:00:00Z");
        hist.setHistory(Arrays.asList(s1, s2, s3));
        return hist;
    }
}
