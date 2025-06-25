package com.voidtracker.oms.order.repository;

import com.voidtracker.oms.order.dto.OrderDto;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OrderRepository {
    private final Map<String, OrderDto> orders = new HashMap<>();

    public void save(OrderDto order) {
        orders.put(order.orderId(), order);
    }

    public Optional<OrderDto> findById(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    public List<OrderDto> findAll() {
        return new ArrayList<>(orders.values());
    }

    public void delete(String orderId) {
        orders.remove(orderId);
    }
}
