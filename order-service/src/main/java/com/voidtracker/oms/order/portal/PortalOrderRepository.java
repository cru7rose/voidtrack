package com.voidtracker.oms.order.portal;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PortalOrderRepository {
    private final Map<String, PortalOrderDto> orders = new HashMap<>();

    public void save(PortalOrderDto order) { orders.put(order.getOrderId(), order); }
    public Optional<PortalOrderDto> findById(String orderId) { return Optional.ofNullable(orders.get(orderId)); }
    public List<PortalOrderDto> findAll() { return new ArrayList<>(orders.values()); }
}
