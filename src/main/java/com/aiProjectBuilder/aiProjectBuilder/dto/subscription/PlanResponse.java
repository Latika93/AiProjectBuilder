package com.aiProjectBuilder.aiProjectBuilder.dto.subscription;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreviews,
        Boolean unlimitedAi,
        String price
) {
}
