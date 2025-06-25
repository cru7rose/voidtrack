package com.voidtracker.oms.commons.dto;

public class ExampleApiErrorDtoFactory {
    public static ApiErrorDto createExampleApiErrorDto() {
        return new ApiErrorDto(
            "ORDER_NOT_FOUND",
            "Nie znaleziono zlecenia o podanym ID.",
            "orderId: a1b2c3d4-e5f6-7890-1234-567890abcdef"
        );
    }
}