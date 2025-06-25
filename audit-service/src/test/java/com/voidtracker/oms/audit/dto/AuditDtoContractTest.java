package com.voidtracker.oms.audit.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

class AuditDtoContractTest {
    @Test
    void auditDtoExampleShouldMatchSchema() throws Exception {
        // Load the example JSON from the classpath to avoid path issues
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/AuditDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            assertNotNull(exampleJson);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            AuditDto dto = mapper.readValue(exampleJson, AuditDto.class);
            assertNotNull(dto);
            assertEquals("Order", dto.entityType());
            assertTrue(exampleJson.contains("entityType"));
            assertTrue(exampleJson.contains("entityId"));
            assertTrue(exampleJson.contains("action"));
        }
    }

    @Test
    void auditDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/AuditDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            AuditDto dto = mapper.readValue(exampleJson, AuditDto.class);
            String serialized = mapper.writeValueAsString(dto);
            AuditDto roundTrip = mapper.readValue(serialized, AuditDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}
