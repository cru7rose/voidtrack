package com.voidtracker.oms.audit.controller;

import com.voidtracker.oms.commons.dto.AuditDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuditControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerAndGetEvent() throws Exception {
        AuditDto event = new AuditDto("evt2", "Order", "order2", "UPDATE", "user2", Instant.now(), "details2");
        String json = objectMapper.writeValueAsString(event);
        // Rejestracja zdarzenia
        mockMvc.perform(post("/api/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Pobranie zdarzenia
        mockMvc.perform(get("/api/audit/evt2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entityId").value("order2"));
    }

    @Test
    void listEvents() throws Exception {
        AuditDto event = new AuditDto("evt3", "Order", "order3", "DELETE", "user3", Instant.now(), "details3");
        String json = objectMapper.writeValueAsString(event);
        mockMvc.perform(post("/api/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/api/audit"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists());
    }
}
