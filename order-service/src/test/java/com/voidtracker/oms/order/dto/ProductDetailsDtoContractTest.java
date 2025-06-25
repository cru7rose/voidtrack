package com.voidtracker.oms.order.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.voidtracker.oms.order.dto.ProductDetailsDto;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDetailsDtoContractTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void productDetailsDtoShouldMatchJsonSchema() throws Exception {
        ProductDetailsDto product = ExampleProductDetailsDtoFactory.createExampleProductDetailsDto();
        String json = objectMapper.writeValueAsString(product);
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/json/ProductDetails_v1.json");
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaStream);
        Set<ValidationMessage> errors = schema.validate(objectMapper.readTree(json));
        assertTrue(errors.isEmpty(), "ProductDetailsDto nie spełnia kontraktu JSON Schema: " + errors);
    }
}
