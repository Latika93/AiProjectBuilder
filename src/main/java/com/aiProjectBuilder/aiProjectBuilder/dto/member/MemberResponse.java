package com.aiProjectBuilder.aiProjectBuilder.dto.member;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
