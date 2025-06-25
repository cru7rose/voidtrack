package com.voidtracker.oms.order.dto;

public class ExampleOrderListItemDtoFactory {
    public static OrderListItemDto createExampleOrderListItemDto() {
        OrderListItemDto item = new OrderListItemDto();
        item.setOrderId("a1b2c3d4-e5f6-7890-1234-567890abcdef");
        item.setStatus("PICKUP");
        item.setPriority("URGENT");
        item.setCustomer("DANXILS Sp. z o.o.");
        item.setCityFrom("Warszawa");
        item.setCityTo("Poznań");
        item.setCreated("2024-06-10T07:30:00Z");
        item.setAssignedDriver("john_doe");
        return item;
    }
}
