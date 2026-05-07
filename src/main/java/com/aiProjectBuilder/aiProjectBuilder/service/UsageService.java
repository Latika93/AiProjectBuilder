package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PlanLimitResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
