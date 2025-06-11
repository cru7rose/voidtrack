package com.voidtracker.oms.commons.dto;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO reprezentujący użytkownika systemu OMS.
 * Immutable, zgodny z katalogiem DTO projektu.
 */
public class UserDto {
    @NotBlank
    private final String id;

    @NotBlank
    @Size(min = 3, max = 50)
    private final String username;

    @NotBlank
    private final String role;

    @NotBlank
    private final String passwordHash;

    @NotNull
    private final Instant lastPasswordChange;

    private final boolean active;

    public UserDto(String id, String username, String role, String passwordHash, Instant lastPasswordChange, boolean active) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.passwordHash = passwordHash;
        this.lastPasswordChange = lastPasswordChange;
        this.active = active;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public String getPasswordHash() { return passwordHash; }
    public Instant getLastPasswordChange() { return lastPasswordChange; }
    public boolean isActive() { return active; }
}
