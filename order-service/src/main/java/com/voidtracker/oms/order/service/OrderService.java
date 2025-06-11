package com.voidtracker.oms.order.service;

import com.voidtracker.oms.commons.dto.OrderDto;
import com.voidtracker.oms.commons.dto.EPodDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private final Map<String, OrderDto> orders = new HashMap<>();
    private final Map<String, List<EPodDto>> epods = new HashMap<>();

    public OrderDto createOrder(OrderDto orderDto) {
        orders.put(orderDto.getOrderId(), orderDto);
        return orderDto;
    }

    public List<OrderDto> listOrders() {
        return new ArrayList<>(orders.values());
    }

    public Optional<OrderDto> getOrder(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    public Optional<OrderDto> updateOrderStatus(String orderId, String status) {
        OrderDto order = orders.get(orderId);
        if (order == null) return Optional.empty();
        order.setStatus(status);
        if (order.getTimestamps() != null) {
            order.getTimestamps().setLastStatusChange(java.time.Instant.now().toString());
        }
        return Optional.of(order);
    }

    public Optional<EPodDto> addEpod(String orderId, EPodDto epodDto) {
        OrderDto order = orders.get(orderId);
        if (order == null) return Optional.empty();
        epods.computeIfAbsent(orderId, k -> new ArrayList<>()).add(epodDto);
        // Dodaj ePoD do listy w OrderDto
        if (order.getEpod() == null) {
            order.setEpod(new ArrayList<>());
        }
        order.getEpod().add(epodDto);
        return Optional.of(epodDto);
    }

    public List<EPodDto> getEpods(String orderId) {
        return epods.getOrDefault(orderId, Collections.emptyList());
    }
}
