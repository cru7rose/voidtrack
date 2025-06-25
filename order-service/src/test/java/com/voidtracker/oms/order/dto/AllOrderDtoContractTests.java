package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class AllOrderDtoContractTests {
    @Test
    void orderDtoContract() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/OrderDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            OrderDto dto = mapper.readValue(exampleJson, OrderDto.class);
            assertNotNull(dto);
            assertEquals("a1b2c3d4-e5f6-7890-1234-567890abcdef", dto.orderId());
            String serialized = mapper.writeValueAsString(dto);
            OrderDto roundTrip = mapper.readValue(serialized, OrderDto.class);
            assertEquals(dto, roundTrip);
            assertTrue(exampleJson.contains("orderId"));
            assertTrue(exampleJson.contains("pickup"));
            assertTrue(exampleJson.contains("delivery"));
            assertTrue(exampleJson.contains("package"));
            assertTrue(exampleJson.contains("timestamps"));
            assertTrue(exampleJson.contains("priority"));
            assertTrue(exampleJson.contains("status"));
        }
    }

    @Test
    void createOrderRequestDtoContract() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/CreateOrderRequestDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            CreateOrderRequestDto dto = mapper.readValue(exampleJson, CreateOrderRequestDto.class);
            assertNotNull(dto);
            assertEquals("URGENT", dto.priority());
            String serialized = mapper.writeValueAsString(dto);
            CreateOrderRequestDto roundTrip = mapper.readValue(serialized, CreateOrderRequestDto.class);
            assertEquals(dto, roundTrip);
            assertTrue(exampleJson.contains("priority"));
            assertTrue(exampleJson.contains("pickup"));
            assertTrue(exampleJson.contains("delivery"));
            assertTrue(exampleJson.contains("package"));
        }
    }

    @Test
    void orderConfirmationResponseDtoContract() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/OrderConfirmationResponseDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            OrderConfirmationResponseDto dto = mapper.readValue(exampleJson, OrderConfirmationResponseDto.class);
            assertNotNull(dto);
            assertEquals("CONFIRMED", dto.confirmationStatus());
            String serialized = mapper.writeValueAsString(dto);
            OrderConfirmationResponseDto roundTrip = mapper.readValue(serialized, OrderConfirmationResponseDto.class);
            assertEquals(dto, roundTrip);
            assertTrue(exampleJson.contains("orderId"));
            assertTrue(exampleJson.contains("confirmationStatus"));
        }
    }

    @Test
    void epodDtoContract() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/ePoDDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            OrderDto.EpodDto dto = mapper.readValue(exampleJson, OrderDto.EpodDto.class);
            assertNotNull(dto);
            assertEquals("epod-001", dto.id());
            String serialized = mapper.writeValueAsString(dto);
            OrderDto.EpodDto roundTrip = mapper.readValue(serialized, OrderDto.EpodDto.class);
            assertEquals(dto, roundTrip);
            assertTrue(exampleJson.contains("id"));
            assertTrue(exampleJson.contains("orderId"));
            assertTrue(exampleJson.contains("signature"));
        }
    }
}
