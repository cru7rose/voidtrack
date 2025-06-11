package com.voidtracker.oms.order.controller;

import com.voidtracker.oms.commons.dto.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAndGetOrder() throws Exception {
        OrderDto order = new OrderDto();
        order.setOrderId("test-123");
        order.setStatus("NEW");
        String json = objectMapper.writeValueAsString(order);

        // Tworzenie zlecenia
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

        // Pobranie zlecenia
        mockMvc.perform(get("/api/orders/test-123"))
                .andExpect(status().isOk());
    }

    @Test
    void updateOrderStatus() throws Exception {
        OrderDto order = new OrderDto();
        order.setOrderId("test-456");
        order.setStatus("NEW");
        String json = objectMapper.writeValueAsString(order);
        // Tworzenie zlecenia
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Zmiana statusu
        mockMvc.perform(patch("/api/orders/test-456")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"PICKUP\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("PICKUP"));
    }

    @Test
    void addAndGetEpod() throws Exception {
        OrderDto order = new OrderDto();
        order.setOrderId("test-789");
        order.setStatus("NEW");
        String json = objectMapper.writeValueAsString(order);
        // Tworzenie zlecenia
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Dodanie ePoD
        String epodJson = "{" +
                "\"epodId\":\"epod-1\"," +
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
        // Pobranie ePoD
        mockMvc.perform(get("/api/orders/test-789/epod"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].epodId").value("epod-1"));
    }
}
