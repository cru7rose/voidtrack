package com.voidtracker.oms.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.voidtracker.oms.order.dto.OrderDto;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@SpringBootTest(classes = com.voidtracker.oms.order.OrderServiceApplication.class)
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private OrderDto createMinimalOrder(String orderId, String status) {
        OrderDto.PartyDto pickup = new OrderDto.PartyDto(
            "customer1", "alias1", "PL", 1, "00-001", "Warsaw", "Main St", "1A", "John Doe", "", "route1", "part1", "type1", "2024-06-10", OffsetDateTime.now(), OffsetDateTime.now().plusHours(1), "john@example.com", "+48123456789", "note", OffsetDateTime.now().plusDays(1)
        );
        OrderDto.PartyDto delivery = new OrderDto.PartyDto(
            "customer2", "alias2", "PL", 2, "00-002", "Krakow", "Second St", "2B", "Jane Doe", "", "route2", "part2", "type2", "2024-06-11", OffsetDateTime.now(), OffsetDateTime.now().plusHours(2), "jane@example.com", "+48987654321", "note2", OffsetDateTime.now().plusDays(2)
        );
        OrderDto.PackageDimensionsDto dims = new OrderDto.PackageDimensionsDto(1.0, 2.0, 3.0);
        OrderDto.PackageDto pkg = new OrderDto.PackageDto(
            "barcode1", "barcode2", 1, 10.0, 0.5, 100.0, "STANDARD", dims, "driver note", "invoice note", 99.99, "PLN", false
        );
        OrderDto.TimestampsDto timestamps = new OrderDto.TimestampsDto(OffsetDateTime.now(), OffsetDateTime.now());
        return new OrderDto(
            orderId,
            status,
            "NORMAL",
            pickup,
            delivery,
            pkg,
            timestamps,
            "john_doe",
            List.of()
        );
    }

    @Test
    void createAndGetOrder() throws Exception {
        OrderDto order = createMinimalOrder("test-123", "NEW");
        String json = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/api/orders/test-123"))
                .andExpect(status().isOk());
    }

    @Test
    void updateOrderStatus() throws Exception {
        OrderDto order = createMinimalOrder("test-456", "NEW");
        String json = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(patch("/api/orders/test-456")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"PICKUP\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("PICKUP"));
    }

    @Test
    void addAndGetEpod() throws Exception {
        OrderDto order = createMinimalOrder("test-789", "NEW");
        String json = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        String epodJson = "{" +
                "\"id\":\"epod-1\"," +
                "\"orderId\":\"test-789\"," +
                "\"timestamp\":\"2024-06-10T10:00:00Z\"," +
                "\"userId\":\"driver1\"," +
                "\"signature\":\"base64data\"," +
                "\"photos\":[]" +
                "}";
        mockMvc.perform(post("/api/orders/test-789/epod")
                .contentType(MediaType.APPLICATION_JSON)
                .content(epodJson))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/api/orders/test-789/epod"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("epod-1"));
    }
}
