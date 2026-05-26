package com.aiProjectBuilder.aiProjectBuilder.dto.project;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}

