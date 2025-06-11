package com.voidtracker.oms.order.controller;

import com.voidtracker.oms.commons.dto.OrderDto;
import com.voidtracker.oms.commons.dto.EPodDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
@Validated
public class OrderController {

    private final com.voidtracker.oms.order.service.OrderService orderService;

    public OrderController(com.voidtracker.oms.order.service.OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        OrderDto created = orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String customer,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size) {
        List<OrderDto> filtered = orderService.listOrders();
        return ResponseEntity.ok(filtered);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrderStatus(
            @PathVariable String orderId,
            @RequestBody Map<String, String> body) {
        String status = body.get("status");
        return orderService.updateOrderStatus(orderId, status)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/{orderId}/epod")
    public ResponseEntity<EPodDto> addEpod(
            @PathVariable String orderId,
            @Valid @RequestBody EPodDto epodDto) {
        return orderService.addEpod(orderId, epodDto)
                .map(e -> ResponseEntity.status(HttpStatus.CREATED).body(e))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{orderId}/epod")
    public ResponseEntity<List<EPodDto>> getEpods(@PathVariable String orderId) {
        if (!orderService.getOrder(orderId).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<EPodDto> list = orderService.getEpods(orderId);
        return ResponseEntity.ok(list);
    }
}
