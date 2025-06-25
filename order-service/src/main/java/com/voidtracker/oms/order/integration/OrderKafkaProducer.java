package com.voidtracker.oms.order.integration;

import com.voidtracker.oms.order.dto.CreateOrderRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Stub for sending order events to Kafka (async order creation).
 */
@Component
public class OrderKafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(OrderKafkaProducer.class);

    public void sendOrderCreatedEvent(CreateOrderRequestDto request) {
        // TODO: Implement Kafka integration
        log.info("[KAFKA] Order created event sent for request: {}", request);
    }
}
