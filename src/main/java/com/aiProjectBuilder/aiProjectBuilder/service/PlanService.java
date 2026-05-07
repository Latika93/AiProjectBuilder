package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
