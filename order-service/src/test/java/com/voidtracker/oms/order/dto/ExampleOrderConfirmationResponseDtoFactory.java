package com.voidtracker.oms.order.dto;

public class ExampleOrderConfirmationResponseDtoFactory {
    public static OrderConfirmationResponseDto createExampleOrderConfirmationResponseDto() {
        return new OrderConfirmationResponseDto(
            "a1b2c3d4-e5f6-7890-1234-567890abcdef",
            "CONFIRMED",
            "2024-06-10T08:10:00Z"
        );
    }
}
