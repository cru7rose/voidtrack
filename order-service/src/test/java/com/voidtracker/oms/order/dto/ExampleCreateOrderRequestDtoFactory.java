package com.voidtracker.oms.order.dto;

public class ExampleCreateOrderRequestDtoFactory {
    public static CreateOrderRequestDto createExampleCreateOrderRequestDto() {
        CreateOrderRequestDto.PartyDto pickup = new CreateOrderRequestDto.PartyDto(
            "customer1", "alias1", "PL", 1, "00-001", "Warsaw", "Main St", "1A", "John Doe", "", "route1", "part1", "type1", "2024-06-10", null, null, "john@example.com", "+48123456789", "note", null
        );
        CreateOrderRequestDto.PartyDto delivery = new CreateOrderRequestDto.PartyDto(
            "customer2", "alias2", "PL", 2, "00-002", "Krakow", "Second St", "2B", "Jane Doe", "", "route2", "part2", "type2", "2024-06-11", null, null, "jane@example.com", "+48987654321", "note2", null
        );
        CreateOrderRequestDto.PackageDimensionsDto dims = new CreateOrderRequestDto.PackageDimensionsDto(1.0, 2.0, 3.0);
        CreateOrderRequestDto.PackageDto pkg = new CreateOrderRequestDto.PackageDto(
            "barcode1", "barcode2", 1, 10.0, 0.5, 100.0, "STANDARD", dims, "driver note", "invoice note", 99.99, "PLN", false
        );
        return new CreateOrderRequestDto(
            "customer1",
            pickup,
            delivery,
            pkg
        );
    }
}
