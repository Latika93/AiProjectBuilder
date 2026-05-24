package com.aiProjectBuilder.aiProjectBuilder.mapper;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PlanResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Plan;
import com.aiProjectBuilder.aiProjectBuilder.entity.Project;

public interface PlanResponseMapper {
    PlanResponse toPlanResponse(Plan plan);
}
