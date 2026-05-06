package com.aiProjectBuilder.aiProjectBuilder.dto;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
