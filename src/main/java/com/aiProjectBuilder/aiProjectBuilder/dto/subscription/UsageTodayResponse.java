package com.aiProjectBuilder.aiProjectBuilder.dto.subscription;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokensLimit,
        Integer previewsRunning,
        Integer previewsList
) {
}
