package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class OrderConfirmationResponseDtoContractTest {
    @Test
    void orderConfirmationResponseDtoExampleShouldMatchSchema() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schema/example/OrderConfirmationResponseDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            OrderConfirmationResponseDto dto = mapper.readValue(exampleJson, OrderConfirmationResponseDto.class);
            assertNotNull(dto);
            assertEquals("CONFIRMED", dto.confirmationStatus());
        }
    }
}
