package com.voidtracker.oms.order.config;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderCreationConfigService {
    private final Map<String, OrderCreationConfig.OrderCreationMode> config = new HashMap<>();

    public OrderCreationConfig.OrderCreationMode getOrderCreationMode(String custId) {
        return config.getOrDefault(custId, OrderCreationConfig.OrderCreationMode.SYNC);
    }

    public void setOrderCreationMode(String custId, OrderCreationConfig.OrderCreationMode mode) {
        config.put(custId, mode);
    }
}
