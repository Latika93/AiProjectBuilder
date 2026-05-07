package com.aiProjectBuilder.aiProjectBuilder.dto.subscription;

public record UsageTodayResponse(
        int tokenUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsList
) {
}
