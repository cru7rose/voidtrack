package com.voidtracker.oms.order.config;

public class OrderCreationConfig {
    private String custId;
    private OrderCreationMode mode;
    public enum OrderCreationMode { SYNC, ASYNC }
    // getters/setters omitted for brevity
}
