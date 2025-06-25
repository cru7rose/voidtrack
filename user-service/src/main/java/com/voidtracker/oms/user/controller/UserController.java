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
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "User profile and role management API")
public class UserController {

    private final UserService userService;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ObjectMapper objectMapper = new ObjectMapper(); // Prywatna instancja do deserializacji

    public UserController(UserService userService, JsonSchemaValidator jsonSchemaValidator) {
        this.userService = userService;
        this.jsonSchemaValidator = jsonSchemaValidator;
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
            @ApiResponse(responseCode = "200", description = "User details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found")
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
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDto.class)))
    })
    public ResponseEntity<?> createUser(@RequestBody String userDtoJson) {
        try (InputStream schemaStream = new ClassPathResource("schemas/json/UserProfile_v1.json").getInputStream()) {
            jsonSchemaValidator.validate(userDtoJson, schemaStream);
            UserProfileDto userDto = objectMapper.readValue(userDtoJson, UserProfileDto.class);
            UserProfileDto createdUser = userService.createUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            // Zwracamy generyczny błąd walidacji lub odczytu
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", responses = {
            @ApiResponse(responseCode = "200", description = "Updated user", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDto.class)))
    })
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody String userDtoJson) {
        try (InputStream schemaStream = new ClassPathResource("schemas/json/UserProfile_v1.json").getInputStream()) {
            jsonSchemaValidator.validate(userDtoJson, schemaStream);
            UserProfileDto userDto = objectMapper.readValue(userDtoJson, UserProfileDto.class);
            // Upewniamy się, że ID w ścieżce i w ciele żądania się zgadzają
            if (!userDto.id().equals(id)) {
                ApiErrorDto error = new ApiErrorDto("ID_MISMATCH", "User ID in path does not match ID in body.", "Path ID: " + id + ", Body ID: " + userDto.id());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
            UserProfileDto updatedUser = userService.updateUser(id, userDto);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            ApiErrorDto error = new ApiErrorDto("VALIDATION_ERROR", e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", responses = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}