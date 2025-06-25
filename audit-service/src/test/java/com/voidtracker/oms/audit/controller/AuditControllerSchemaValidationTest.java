package com.voidtracker.oms.audit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@WebMvcTest(AuditController.class)
class AuditControllerSchemaValidationTest {
    @MockBean
    private AuditService auditService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRejectInvalidAuditPayload() throws Exception {
        String invalidJson = "{\"auditId\":\"1\"}"; // missing required fields
        org.everit.json.schema.ValidationException validationException = new org.everit.json.schema.ValidationException(null, "Invalid payload", "", "");
        org.mockito.Mockito.doThrow(validationException).when(jsonSchemaValidator).validate(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any());
        mockMvc.perform(post("/api/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("VALIDATION_ERROR"));
    }

    @Test
    void shouldAcceptValidAuditPayload() throws Exception {
        String validJson = "{\"auditId\":\"audit-001\",\"entityType\":\"Order\",\"entityId\":\"a1b2c3d4-e5f6-7890-1234-567890abcdef\",\"action\":\"STATUS_CHANGE\",\"userId\":\"john_doe\",\"timestamp\":\"2024-06-10T12:10:00Z\",\"details\":{\"oldStatus\":\"PICKUP\",\"newStatus\":\"POD\"}}";
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        mockMvc.perform(post("/api/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validJson))
                .andExpect(status().isCreated());
    }
}
