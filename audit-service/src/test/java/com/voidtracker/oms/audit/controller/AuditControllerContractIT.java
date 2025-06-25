package com.voidtracker.oms.audit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidtracker.oms.audit.dto.AuditDto;
import com.voidtracker.oms.audit.dto.ExampleAuditDtoFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuditControllerContractIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAcceptValidAuditDto() throws Exception {
        AuditDto audit = ExampleAuditDtoFactory.createExampleAuditDto();
        mockMvc.perform(post("/api/audit/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(audit)))
                .andExpect(status().isCreated());
    }
}
