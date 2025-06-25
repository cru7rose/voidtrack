package com.voidtracker.oms.user.controller;

import com.voidtracker.oms.user.dto.UserProfileDto;
import com.voidtracker.oms.user.service.UserService;
import com.voidtracker.oms.commons.validation.JsonSchemaValidator;
import org.everit.json.schema.ValidationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.*;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "User profile and role management API")
public class UserController {
    private final UserService userService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final String userProfileSchema;

    public UserController(UserService userService, JsonSchemaValidator jsonSchemaValidator) throws Exception {
        this.userService = userService;
        this.jsonSchemaValidator = jsonSchemaValidator;
        // Load schema from classpath
        var resource = new ClassPathResource("schemas/json/UserProfile_v1.json");
        this.userProfileSchema = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    @GetMapping
    @Operation(summary = "List all users", responses = {
        @ApiResponse(responseCode = "200", description = "List of users", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class)))
    })
    public List<UserProfileDto> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user details", responses = {
        @ApiResponse(responseCode = "200", description = "User details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class)))
    })
    public ResponseEntity<UserProfileDto> getUser(@PathVariable String id) {
        UserProfileDto user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Operation(summary = "Create new user", responses = {
        @ApiResponse(responseCode = "201", description = "Created user", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.voidtracker.oms.commons.dto.ApiErrorDto.class)))
    })
    public ResponseEntity<?> createUser(@RequestBody String userDtoJson) throws Exception {
        try {
            jsonSchemaValidator.validate(userDtoJson, userProfileSchema);
            UserProfileDto userDto = new com.fasterxml.jackson.databind.ObjectMapper().readValue(userDtoJson, UserProfileDto.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("errorCode", "VALIDATION_ERROR", "message", e.getMessage())
            );
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", responses = {
        @ApiResponse(responseCode = "200", description = "Updated user", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.voidtracker.oms.commons.dto.ApiErrorDto.class)))
    })
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody String userDtoJson) throws Exception {
        try {
            jsonSchemaValidator.validate(userDtoJson, userProfileSchema);
            UserProfileDto userDto = new com.fasterxml.jackson.databind.ObjectMapper().readValue(userDtoJson, UserProfileDto.class);
            return ResponseEntity.ok(userService.updateUser(id, userDto));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("errorCode", "VALIDATION_ERROR", "message", e.getMessage())
            );
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
