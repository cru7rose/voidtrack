package com.voidtracker.oms.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String role;
    private String passwordHash;
    private Instant lastPasswordChange;
    private boolean active;
}
