package com.voidtracker.oms.user.dto;

public record UserProfileDto(
    String id,
    String username,
    String role,
    boolean active
) {

}
