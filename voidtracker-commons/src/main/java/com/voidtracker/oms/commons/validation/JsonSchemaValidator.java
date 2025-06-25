package com.voidtracker.oms.commons.validation;

import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.Schema;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

@Component
public class JsonSchemaValidator {
    public void validate(String json, String schemaContent) {
        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaContent));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(json)); // throws ValidationException if invalid
    }
}
