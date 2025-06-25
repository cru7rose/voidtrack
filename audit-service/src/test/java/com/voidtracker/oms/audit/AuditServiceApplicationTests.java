package com.voidtracker.oms.audit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.audit.service.AuditService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@SpringBootTest
class AuditServiceApplicationTests {
    @MockBean
    private AuditService auditService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;

    @Test
    void contextLoads() {
    }

}
