package com.voidtracker.oms.order.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderDto(
    String orderId,
    String status,
    String priority,
    PartyDto pickup,
    PartyDto delivery,
    @JsonProperty("package") PackageDto aPackage,
    TimestampsDto timestamps,
    String assignedDriver,
    List<EpodDto> epod
) {

    public record PartyDto(
        String customer,
        String alias,
        String country,
        Integer addressId,
        String postalCode,
        String city,
        String street,
        String streetNumber,
        String name,
        String attention,
        String route,
        String routePart,
        String type,
        String manifestDate,
        OffsetDateTime windowFrom,
        OffsetDateTime windowTo,
        String mail,
        String phone,
        String note,
        OffsetDateTime sla
    ) {}

    public record PackageDto(
        String barcode1,
        String barcode2,
        Integer colli,
        Double weight,
        Double volume,
        Double routeDistance,
        String serviceType,
        PackageDimensionsDto packageDimensions,
        String driverNote,
        String invoiceNote,
        Double price,
        String currency,
        Boolean adr
    ) {}

    public record PackageDimensionsDto(
        Double length,
        Double width,
        Double height
    ) {}

    public record TimestampsDto(
        OffsetDateTime created,
        OffsetDateTime lastStatusChange
    ) {}

    public record EpodDto(
        String id,
        String orderId,
        String signature,
        List<String> photos,
        OffsetDateTime timestamp,
        String userId
    ) {}
}
