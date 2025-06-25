package com.voidtracker.oms.commons.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.StandardCharsets;

class ApiErrorDtoContractTest {
    @Test
    void apiErrorDtoExampleShouldMatchSchema() throws Exception {
        String exampleJson = new String(
            getClass().getResourceAsStream("/schemas/json/example/ApiErrorDto_example.json").readAllBytes(),
            StandardCharsets.UTF_8
        );
        assertNotNull(exampleJson);
        assertTrue(exampleJson.contains("errorCode"));
        assertTrue(exampleJson.contains("message"));
    }
}
