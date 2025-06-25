package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDtoExampleValidationTest {
    @Test
    void orderDtoExampleShouldContainAllRequiredFields() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/OrderDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            assertTrue(exampleJson.contains("orderId"));
            assertTrue(exampleJson.contains("pickup"));
            assertTrue(exampleJson.contains("delivery"));
            assertTrue(exampleJson.contains("package"));
            assertTrue(exampleJson.contains("timestamps"));
            assertTrue(exampleJson.contains("priority"));
            assertTrue(exampleJson.contains("status"));
        }
    }
}
