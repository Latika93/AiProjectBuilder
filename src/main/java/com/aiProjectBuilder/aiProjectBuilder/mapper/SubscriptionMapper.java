package com.aiProjectBuilder.aiProjectBuilder.mapper;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PlanResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.SubscriptionResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Plan;
import com.aiProjectBuilder.aiProjectBuilder.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}