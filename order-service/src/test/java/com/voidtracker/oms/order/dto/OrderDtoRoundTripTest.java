package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class OrderDtoRoundTripTest {
    @Test
    void orderDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/OrderDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            OrderDto dto = mapper.readValue(exampleJson, OrderDto.class);
            String serialized = mapper.writeValueAsString(dto);
            OrderDto roundTrip = mapper.readValue(serialized, OrderDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}
