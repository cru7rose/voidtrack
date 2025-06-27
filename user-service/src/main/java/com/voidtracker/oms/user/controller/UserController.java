package com.voidtracker.oms.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidtracker.oms.commons.dto.ApiErrorDto;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import com.voidtracker.oms.user.dto.UserProfileDto;
import com.voidtracker.oms.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.everit.json.schema.ValidationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "User profile and role management API")
public class UserController {

    private final UserService userService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ObjectMapper objectMapper;
    private final String userProfileSchema;

    public UserController(UserService userService, JsonSchemaValidator jsonSchemaValidator, ObjectMapper objectMapper) throws Exception {
        this.userService = userService;
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.objectMapper = objectMapper;
        // Wczytujemy schemat raz, podczas tworzenia kontrolera
        var resource = new ClassPathResource("schemas/json/UserProfile_v1.json");
        this.userProfileSchema = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    @GetMapping
    @Operation(summary = "List all users")
    public List<UserProfileDto> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user details")
    public ResponseEntity<UserProfileDto> getUser(@PathVariable String id) {
        UserProfileDto user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Operation(summary = "Create new user")
    public ResponseEntity<?> createUser(@RequestBody String userDtoJson) {
        try {
            jsonSchemaValidator.validate(userDtoJson, userProfileSchema);
            UserProfileDto userDto = objectMapper.readValue(userDtoJson, UserProfileDto.class);
            UserProfileDto createdUser = userService.createUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (ValidationException e) {
            // Przechwytujemy specyficzny wyjątek z Everit i tworzymy czytelną odpowiedź
            String errorDetails = e.getAllMessages().stream().collect(Collectors.joining(", "));
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), errorDetails);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception e) {
            ApiErrorDto error = new ApiErrorDto("REQUEST_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody String userDtoJson) {
        try {
            jsonSchemaValidator.validate(userDtoJson, userProfileSchema);
            UserProfileDto userDto = objectMapper.readValue(userDtoJson, UserProfileDto.class);
            UserProfileDto updatedUser = userService.updateUser(id, userDto);
            return ResponseEntity.ok(updatedUser);
        } catch (ValidationException e) {
            String errorDetails = e.getAllMessages().stream().collect(Collectors.joining(", "));
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), errorDetails);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception e) {
            ApiErrorDto error = new ApiErrorDto("REQUEST_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}