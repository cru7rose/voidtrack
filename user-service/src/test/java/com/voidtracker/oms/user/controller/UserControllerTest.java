package com.voidtracker.oms.user.controller;

import com.voidtracker.oms.user.dto.UserProfileDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.voidtracker.oms.user.service.UserService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    private UserService userService;
    @MockBean
    private JsonSchemaValidator jsonSchemaValidator;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAndGetUser() throws Exception {
        UserProfileDto user = new UserProfileDto("id2", "user2", "USER", true);
        String json = objectMapper.writeValueAsString(user);
        when(userService.createUser(any())).thenReturn(user);
        when(userService.getUser("id2")).thenReturn(user);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/api/users/id2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user2"));
    }

    @Test
    void updateUser() throws Exception {
        UserProfileDto user = new UserProfileDto("id3", "user3", "USER", true);
        UserProfileDto updated = new UserProfileDto("id3", "user3x", "ADMIN", false);
        String json = objectMapper.writeValueAsString(user);
        String updatedJson = objectMapper.writeValueAsString(updated);
        when(userService.createUser(any())).thenReturn(user);
        when(userService.updateUser(eq("id3"), any())).thenReturn(updated);
        when(userService.getUser("id3")).thenReturn(updated);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(put("/api/users/id3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user3x"));
    }

    @Test
    void deleteUser() throws Exception {
        UserProfileDto user = new UserProfileDto("id4", "user4", "USER", true);
        String json = objectMapper.writeValueAsString(user);
        when(userService.createUser(any())).thenReturn(user);
        when(userService.getUser("id4")).thenReturn(user).thenReturn(null);
        doNothing().when(userService).deleteUser("id4");
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(delete("/api/users/id4"))
                .andExpect(status().isNoContent());
        // After deletion, explicitly set the mock to return null
        when(userService.getUser("id4")).thenReturn(null);
        mockMvc.perform(get("/api/users/id4"))
                .andExpect(status().isNotFound());
    }
}
