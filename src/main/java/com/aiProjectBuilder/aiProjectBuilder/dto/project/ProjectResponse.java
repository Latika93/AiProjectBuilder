package com.aiProjectBuilder.aiProjectBuilder.dto.project;

import com.aiProjectBuilder.aiProjectBuilder.dto.auth.UserProfileResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
