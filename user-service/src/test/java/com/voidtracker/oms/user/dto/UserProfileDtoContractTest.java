package com.voidtracker.oms.user.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

class UserProfileDtoContractTest {
    @Test
    void userProfileDtoExampleShouldMatchSchema() throws Exception {
        ClassPathResource resource = new ClassPathResource("schemas/json/example/UserProfileDto_example.json");
        try (InputStream is = resource.getInputStream()) {
            String exampleJson = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            assertNotNull(exampleJson);
            ObjectMapper mapper = new ObjectMapper();
            UserProfileDto dto = mapper.readValue(exampleJson, UserProfileDto.class);
            assertNotNull(dto);
            assertEquals("john_doe", dto.username());
            assertTrue(exampleJson.contains("username"));
            assertTrue(exampleJson.contains("role"));
        }
    }

    @Test
    void userProfileDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        ClassPathResource resource = new ClassPathResource("schemas/json/example/UserProfileDto_example.json");
        try (InputStream is = resource.getInputStream()) {
            String exampleJson = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            UserProfileDto dto = mapper.readValue(exampleJson, UserProfileDto.class);
            String serialized = mapper.writeValueAsString(dto);
            UserProfileDto roundTrip = mapper.readValue(serialized, UserProfileDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}
