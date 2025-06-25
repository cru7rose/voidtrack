package com.voidtracker.oms.order.service;

import com.voidtracker.oms.order.dto.*;
import com.voidtracker.oms.commons.dto.ApiErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    // In-memory store for demo; replace with repository/DB in production
    private final Map<String, OrderDto> orders = new HashMap<>();
    private final Map<String, String> customerOrderMode = new HashMap<>(); // custId -> "SYNC" or "ASYNC"

    @Override
    public ResponseEntity<?> createOrQueueOrder(CreateOrderRequestDto request, String custId) {
        String mode = customerOrderMode.getOrDefault(custId, "SYNC");
        if ("ASYNC".equalsIgnoreCase(mode)) {
            // TODO: Send to Kafka or queue for async processing
            return ResponseEntity.accepted().body(new OrderConfirmationResponseDto(UUID.randomUUID().toString(), "QUEUED", ""));
        } else {
            // Synchronous creation
            String orderId = UUID.randomUUID().toString();
            // TODO: Map all required fields from request
            OrderDto order = new OrderDto(
                orderId, // orderId
                "NEW", // status
                "NORMAL", // priority (placeholder)
                null, // pickup
                null, // delivery
                null, // aPackage
                null, // timestamps
                null, // assignedDriver
                List.of() // epod
            );
            orders.put(orderId, order);
            return ResponseEntity.status(201).body(new OrderConfirmationResponseDto(orderId, "CREATED", ""));
        }
    }

    @Override
    public List<OrderListItemDto> listOrders(OrderSearchCriteria criteria) {
        // TODO: Implement filtering by address, barcode, custId, alias, pagination
        return new ArrayList<>();
    }

    @Override
    public Optional<OrderDto> getOrder(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    @Override
    public ResponseEntity<?> changeOrderStatus(String orderId, OrderStatusChangeRequestDto request) {
        OrderDto order = orders.get(orderId);
        if (order == null) {
            return ResponseEntity.status(404).body(new ApiErrorDto("NOT_FOUND", "Order not found", ""));
        }
        // TODO: Add to OrderStatusHistory, set lastStatusChange, etc.
        // To "change" status, create a new record instance
        order = new OrderDto(
            order.orderId(),
            request.getStatus(),
            order.priority(),
            order.pickup(),
            order.delivery(),
            order.aPackage(),
            order.timestamps(),
            order.assignedDriver(),
            order.epod()
        );
        orders.put(orderId, order);
        return ResponseEntity.ok(order);
    }

    @Override
    public void softDeleteOrder(String orderId) {
        OrderDto order = orders.get(orderId);
        if (order != null) {
            // To "soft delete", create a new record instance with updated fields
            order = new OrderDto(
                order.orderId(),
                order.status(),
                order.priority(),
                order.pickup(),
                order.delivery(),
                order.aPackage(),
                order.timestamps(),
                order.assignedDriver(),
                order.epod()
            );
            // TODO: If you add deleted/deletedAt fields to the record, update here
            orders.put(orderId, order);
        }
    }
}
