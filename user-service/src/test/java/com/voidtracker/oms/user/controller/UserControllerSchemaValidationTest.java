package com.voidtracker.oms.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.user.service.UserService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@WebMvcTest(UserController.class)
class UserControllerSchemaValidationTest {
    @MockBean
    private UserService userService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRejectInvalidUserPayload() throws Exception {
        String invalidJson = "{\"id\":\"user-001\"}"; // missing required fields
        doThrow(new org.everit.json.schema.ValidationException(null, "Invalid payload".getClass(), "", "")).when(jsonSchemaValidator).validate(any(), any());
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("VALIDATION_ERROR"));
    }

    @Test
    void shouldAcceptValidUserPayload() throws Exception {
        String validJson = "{\"id\":\"user-001\",\"username\":\"john_doe\",\"role\":\"admin\",\"active\":true}";
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validJson))
                .andExpect(status().isCreated());
    }
}
