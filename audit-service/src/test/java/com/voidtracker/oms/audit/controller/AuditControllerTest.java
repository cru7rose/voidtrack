package com.voidtracker.oms.audit.controller;

import com.voidtracker.oms.audit.dto.AuditDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@WebMvcTest(AuditController.class)
class AuditControllerTest {
    @MockBean
    private AuditService auditService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;
    @Autowired
    private MockMvc mockMvc;

    // Use direct instantiation to avoid autowiring issues
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

    @Test
    void shouldCreateAuditEvent() throws Exception {
        AuditDto auditDto = new AuditDto(
            "audit-001",
            "Order",
            "a1b2c3d4-e5f6-7890-1234-567890abcdef",
            "STATUS_CHANGE",
            "john_doe",
            java.time.OffsetDateTime.parse("2024-06-10T12:10:00Z"),
            java.util.Map.of("oldStatus", "PICKUP", "newStatus", "POD")
        );
        String json = objectMapper.writeValueAsString(auditDto);
        mockMvc.perform(post("/api/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }
}
