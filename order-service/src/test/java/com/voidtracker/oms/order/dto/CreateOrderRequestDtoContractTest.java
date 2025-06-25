package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class CreateOrderRequestDtoContractTest {
    @Test
    void createOrderRequestDtoExampleShouldMatchSchema() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/CreateOrderRequestDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            CreateOrderRequestDto dto = mapper.readValue(exampleJson, CreateOrderRequestDto.class);
            assertNotNull(dto);
            assertEquals("URGENT", dto.priority());
        }
    }
}
