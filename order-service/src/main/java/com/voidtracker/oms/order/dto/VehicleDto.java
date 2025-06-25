package com.voidtracker.oms.order.dto;

import java.time.OffsetDateTime;

public record VehicleDto(
    String vehicleId,
    String registrationNumber,
    String type,
    String brand,
    String model,
    double capacityKg,
    DimensionsDto dimensions,
    String status,
    OffsetDateTime lastInspection,
    OffsetDateTime nextInspection,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
    public record DimensionsDto(
        double length,
        double width,
        double height
    ) {}
}
