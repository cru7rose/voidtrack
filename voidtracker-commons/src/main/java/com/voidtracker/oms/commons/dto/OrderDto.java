package com.voidtracker.oms.commons.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object dla zlecenia.
 * Używany do komunikacji przez API (np. między frontendem a order-service).
 * Zawiera wszystkie informacje potrzebne do wyświetlenia lub utworzenia zlecenia.
 */
@Data
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String status;
    private String priority;
    private PickupPointDto pickup;
    private DeliveryPointDto delivery;
    private PackageDto aPackage;
    private TimestampsDto timestamps;
    private String assignedDriver;
    private List<EPodDto> epod;

    @Data
    @NoArgsConstructor
    public static class PickupPointDto {
        private String customer;
        private String alias;
        private String country;
        private Integer addressId;
        private String postalCode;
        private String city;
        private String street;
        private String streetNumber;
        private String name;
        private String attention;
        private String route;
        private String routePart;
        private String type;
        private String manifestDate;
        private String windowFrom;
        private String windowTo;
        private String mail;
        private String phone;
        private String note;
    }

    @Data
    @NoArgsConstructor
    public static class DeliveryPointDto {
        private String customer;
        private String alias;
        private String country;
        private Integer addressId;
        private String postalCode;
        private String city;
        private String street;
        private String streetNumber;
        private String name;
        private String attention;
        private String route;
        private String routePart;
        private String type;
        private String manifestDate;
        private String sla;
        private String windowFrom;
        private String windowTo;
        private String mail;
        private String phone;
        private String note;
    }

    @Data
    @NoArgsConstructor
    public static class PackageDto {
        private String barcode1;
        private String barcode2;
        private Integer colli;
        private Double weight;
        private Double volume;
        private Double routeDistance;
        private String serviceType;
        private PackageDimensionsDto packageDimensions;
        private String driverNote;
        private String invoiceNote;
        private Double price;
        private String currency;
        private Boolean adr;
    }

    @Data
    @NoArgsConstructor
    public static class PackageDimensionsDto {
        private Double length;
        private Double width;
        private Double height;
    }

    @Data
    @NoArgsConstructor
    public static class TimestampsDto {
        private String created;
        private String lastStatusChange;
    }
}