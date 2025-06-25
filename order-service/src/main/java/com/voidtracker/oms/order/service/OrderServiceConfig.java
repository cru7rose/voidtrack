package com.voidtracker.oms.order.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {
    @Value("${order.defaultPageSize:20}")
    private int defaultPageSize;

    public int getDefaultPageSize() {
        return defaultPageSize;
    }
}
