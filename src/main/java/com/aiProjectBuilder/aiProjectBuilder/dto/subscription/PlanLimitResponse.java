package com.aiProjectBuilder.aiProjectBuilder.dto.subscription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitdAi
) {
}
