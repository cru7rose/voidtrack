package com.voidtracker.oms.order.dto;

public class ExampleOrderEventDtoFactory {
    public static OrderEventDto createExampleOrderEventDto() {
        OrderEventDto event = new OrderEventDto();
        event.setEventId("evt-1");
        event.setOrderId("a1b2c3d4-e5f6-7890-1234-567890abcdef");
        event.setType("STATUS_CHANGE");
        event.setStatusFrom("PICKUP");
        event.setStatusTo("LOAD");
        event.setTimestamp("2024-06-10T08:10:00Z");
        event.setUserId("john_doe");
        return event;
    }
}
