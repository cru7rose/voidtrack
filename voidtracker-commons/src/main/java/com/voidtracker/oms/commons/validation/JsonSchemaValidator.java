package com.voidtracker.oms.commons.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Component
public class JsonSchemaValidator {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

    /**
     * Waliduje obiekt JSON (w formie Stringa) względem schematu.
     *
     * @param jsonContent String zawierający JSON do walidacji.
     * @param schemaStream InputStream do pliku ze schematem JSON.
     * @throws IOException jeśli wystąpi błąd odczytu JSON.
     * @throws IllegalArgumentException jeśli walidacja się nie powiedzie.
     */
    public void validate(String jsonContent, InputStream schemaStream) throws IOException {
        if (schemaStream == null) {
            throw new IllegalArgumentException("Schema stream cannot be null. Check if the schema file exists on the classpath.");
        }

        JsonSchema schema = factory.getSchema(schemaStream);
        JsonNode jsonNode = objectMapper.readTree(jsonContent);

        Set<ValidationMessage> errors = schema.validate(jsonNode);

        if (!errors.isEmpty()) {
            // Rzucamy wyjątek z informacjami o błędach walidacji
            throw new IllegalArgumentException("JSON validation failed: " + errors);
        }
    }
}