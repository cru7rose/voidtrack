package com.voidtracker.oms.order.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record RouteDto(
    String routeId,
    String orderId,
    String vehicleId,
    String driverId,
    String status,
    List<StopDto> stops,
    OffsetDateTime plannedStart,
    OffsetDateTime plannedEnd,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
    public record StopDto(
        String stopId,
        String address,
        OffsetDateTime eta,
        OffsetDateTime actualArrival,
        OffsetDateTime actualDeparture
    ) {}
}
