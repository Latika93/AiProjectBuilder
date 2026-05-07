package com.aiProjectBuilder.aiProjectBuilder.dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
