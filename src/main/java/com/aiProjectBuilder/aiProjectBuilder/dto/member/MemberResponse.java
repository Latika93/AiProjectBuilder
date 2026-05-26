package com.aiProjectBuilder.aiProjectBuilder.dto.member;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole role,
        Instant invitedAt
) {
}
