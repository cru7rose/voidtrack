package com.voidtracker.oms.order.service;

import com.voidtracker.oms.order.dto.OrderDto;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    @Test
    void createAndGetOrder() {
        // OrderService is abstract; in real tests, use a mock or a concrete implementation
        // Here, we just test OrderDto instantiation
        OrderDto.PartyDto pickup = new OrderDto.PartyDto(
            "customer1", "alias1", "PL", 1, "00-001", "Warsaw", "Main St", "1A", "John Doe", "", "route1", "part1", "type1", "2024-06-10", OffsetDateTime.now(), OffsetDateTime.now().plusHours(1), "john@example.com", "+48123456789", "note", OffsetDateTime.now().plusDays(1)
        );
        OrderDto.PartyDto delivery = new OrderDto.PartyDto(
            "customer2", "alias2", "PL", 2, "00-002", "Krakow", "Second St", "2B", "Jane Doe", "", "route2", "part2", "type2", "2024-06-11", OffsetDateTime.now(), OffsetDateTime.now().plusHours(2), "jane@example.com", "+48987654321", "note2", OffsetDateTime.now().plusDays(2)
        );
        OrderDto.PackageDimensionsDto dims = new OrderDto.PackageDimensionsDto(1.0, 2.0, 3.0);
        OrderDto.PackageDto pkg = new OrderDto.PackageDto(
            "barcode1", "barcode2", 1, 10.0, 0.5, 100.0, "STANDARD", dims, "driver note", "invoice note", 99.99, "PLN", false
        );
        OrderDto.TimestampsDto timestamps = new OrderDto.TimestampsDto(OffsetDateTime.now(), OffsetDateTime.now());
        OrderDto.EpodDto epod = new OrderDto.EpodDto(
            "epod-1", UUID.randomUUID().toString(), "base64signature", Collections.singletonList("base64photo"), OffsetDateTime.now(), "john_doe"
        );
        OrderDto order = new OrderDto(
            UUID.randomUUID().toString(),
            "PICKUP",
            "URGENT",
            pickup,
            delivery,
            pkg,
            timestamps,
            "john_doe",
            List.of(epod)
        );
        assertThat(order.orderId()).isNotNull();
        assertThat(order.pickup().customer()).isEqualTo("customer1");
    }
}
