package com.aiProjectBuilder.aiProjectBuilder.dto;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
