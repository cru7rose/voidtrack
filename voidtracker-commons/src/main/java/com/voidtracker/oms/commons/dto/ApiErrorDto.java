package com.voidtracker.oms.commons.dto;

public record ApiErrorDto(
    String errorCode,
    String message,
    String details
) {}
