package com.aiProjectBuilder.aiProjectBuilder.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
