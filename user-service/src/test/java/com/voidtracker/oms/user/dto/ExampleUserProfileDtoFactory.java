package com.voidtracker.oms.user.dto;

public class ExampleUserProfileDtoFactory {
    public static UserProfileDto createExampleUserProfileDto() {
        return new UserProfileDto(
            "a1b2c3d4-e5f6-7890-1234-567890abcdef", // userId
            "john_doe", // username
            "John Doe", // fullName
            true // active (example boolean, adjust as per your record definition)
        );
    }
}
