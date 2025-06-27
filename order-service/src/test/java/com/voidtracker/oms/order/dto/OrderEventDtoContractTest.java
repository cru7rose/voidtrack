package com.voidtracker.oms.order.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class OrderEventDtoContractTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JsonSchemaValidator jsonSchemaValidator;

    @Test
    void orderEventDtoShouldMatchJsonSchema() throws Exception {
        OrderEventDto event = ExampleOrderEventDtoFactory.createExampleOrderEventDto();
        String json = objectMapper.writeValueAsString(event);

        // POPRAWKA: Wczytujemy schemat do Stringa przed walidacją
        String schemaContent;
        try (InputStream schemaStream = new ClassPathResource("schemas/json/OrderEvent_v1.json").getInputStream()) {
            schemaContent = new String(schemaStream.readAllBytes(), StandardCharsets.UTF_8);
        }

        assertDoesNotThrow(() -> {
            jsonSchemaValidator.validate(json, schemaContent);
        }, "OrderEventDto powinien być zgodny ze schematem JSON");
    }
}