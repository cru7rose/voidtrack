package com.voidtracker.oms.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.user.service.UserService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@SpringBootTest
class UserServiceApplicationTests {
    @MockBean
    private UserService userService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;

    @Test
    void contextLoads() {
    }

}
