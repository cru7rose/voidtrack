package com.voidtracker.oms.order.dto;

public record OrderConfirmationResponseDto(
    String orderId,
    String confirmationStatus,
    String message
) {}
