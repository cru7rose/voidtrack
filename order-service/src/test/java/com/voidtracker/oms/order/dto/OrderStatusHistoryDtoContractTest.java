package com.voidtracker.oms.order.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.voidtracker.oms.order.dto.OrderStatusHistoryDto;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderStatusHistoryDtoContractTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void orderStatusHistoryDtoShouldMatchJsonSchema() throws Exception {
        OrderStatusHistoryDto hist = ExampleOrderStatusHistoryDtoFactory.createExampleOrderStatusHistoryDto();
        String json = objectMapper.writeValueAsString(hist);
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/json/OrderStatusHistory_v1.json");
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaStream);
        Set<ValidationMessage> errors = schema.validate(objectMapper.readTree(json));
        assertTrue(errors.isEmpty(), "OrderStatusHistoryDto nie spełnia kontraktu JSON Schema: " + errors);
    }
}
