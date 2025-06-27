package com.voidtracker.oms.commons.validation;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

@Component
public class JsonSchemaValidator {

    /**
     * Waliduje obiekt JSON (w formie Stringa) względem schematu (również w formie Stringa).
     * Zgodne z dokumentacją biblioteki Everit JSON Schema.
     *
     * @param jsonContent String zawierający JSON do walidacji.
     * @param schemaContent String zawierający schemat JSON.
     * @throws org.everit.json.schema.ValidationException jeśli walidacja się nie powiedzie.
     */
    public void validate(String jsonContent, String schemaContent) {
        // Krok 1: Wczytaj schemat ze Stringa
        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaContent));
        Schema schema = SchemaLoader.load(rawSchema);

        // Krok 2: Wczytaj dane JSON do walidacji ze Stringa
        JSONObject subject = new JSONObject(new JSONTokener(jsonContent));

        // Krok 3: Wykonaj walidację. Jeśli dane są nieprawidłowe, metoda rzuci ValidationException.
        schema.validate(subject);
    }
}