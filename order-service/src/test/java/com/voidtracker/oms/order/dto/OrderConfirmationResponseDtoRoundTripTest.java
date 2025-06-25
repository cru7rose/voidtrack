package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class OrderConfirmationResponseDtoRoundTripTest {
    @Test
    void orderConfirmationResponseDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/OrderConfirmationResponseDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            OrderConfirmationResponseDto dto = mapper.readValue(exampleJson, OrderConfirmationResponseDto.class);
            String serialized = mapper.writeValueAsString(dto);
            OrderConfirmationResponseDto roundTrip = mapper.readValue(serialized, OrderConfirmationResponseDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}
