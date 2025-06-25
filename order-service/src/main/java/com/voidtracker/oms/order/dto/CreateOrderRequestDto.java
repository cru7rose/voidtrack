package com.voidtracker.oms.order.dto;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateOrderRequestDto(
    String priority,
    PartyDto pickup,
    PartyDto delivery,
    @JsonProperty("package") PackageDto aPackage
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
}
