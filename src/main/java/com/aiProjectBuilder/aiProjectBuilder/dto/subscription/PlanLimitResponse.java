package com.aiProjectBuilder.aiProjectBuilder.dto.subscription;

public record PlanLimitResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitdAi
) {
}
