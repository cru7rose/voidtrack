package com.voidtracker.oms.order.service;

import com.voidtracker.oms.order.dto.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

/**
 * Service for order business logic. Handles sync/async creation, status changes, soft-delete, and filtering.
 *
 * Order creation mode (sync/async) is determined by customer config (see admin panel).
 */
public interface OrderService {
    /**
     * Create or queue an order based on customer config.
     */
    ResponseEntity<?> createOrQueueOrder(CreateOrderRequestDto request, String custId);

    /**
     * List/search orders with filtering and pagination.
     */
    List<OrderListItemDto> listOrders(OrderSearchCriteria criteria);

    /**
     * Get order details.
     */
    Optional<OrderDto> getOrder(String orderId);

    /**
     * Change order status (e.g., delivery confirmation).
     */
    ResponseEntity<?> changeOrderStatus(String orderId, OrderStatusChangeRequestDto request);

    /**
     * Soft-delete an order.
     */
    void softDeleteOrder(String orderId);
}
