package com.voidtracker.oms.user.controller;

import com.voidtracker.oms.commons.dto.UserDto;
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
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAndGetUser() throws Exception {
        UserDto user = new UserDto("id2", "user2", "USER", "hash2", Instant.now(), true);
        String json = objectMapper.writeValueAsString(user);
        // Tworzenie użytkownika
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Pobranie użytkownika
        mockMvc.perform(get("/api/users/id2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user2"));
    }

    @Test
    void updateUser() throws Exception {
        UserDto user = new UserDto("id3", "user3", "USER", "hash3", Instant.now(), true);
        String json = objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Aktualizacja użytkownika
        UserDto updated = new UserDto("id3", "user3x", "ADMIN", "hash3x", Instant.now(), false);
        String updatedJson = objectMapper.writeValueAsString(updated);
        mockMvc.perform(put("/api/users/id3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user3x"));
    }

    @Test
    void deleteUser() throws Exception {
        UserDto user = new UserDto("id4", "user4", "USER", "hash4", Instant.now(), true);
        String json = objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
        // Usunięcie użytkownika
        mockMvc.perform(delete("/api/users/id4"))
                .andExpect(status().isNoContent());
        // Próba pobrania usuniętego użytkownika
        mockMvc.perform(get("/api/users/id4"))
                .andExpect(status().isNotFound());
    }
}
