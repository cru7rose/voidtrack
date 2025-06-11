package com.voidtracker.oms.order.service;

import com.voidtracker.oms.commons.dto.OrderDto;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    @Test
    void createAndGetOrder() {
        OrderService service = new OrderService();
        OrderDto order = new OrderDto();
        // Zakładamy, że OrderDto ma setOrderId (jeśli nie, należy dodać builder lub konstruktor)
        order.setOrderId(UUID.randomUUID().toString());
        service.createOrder(order);
        assertThat(service.getOrder(order.getOrderId())).isPresent();
    }
}
