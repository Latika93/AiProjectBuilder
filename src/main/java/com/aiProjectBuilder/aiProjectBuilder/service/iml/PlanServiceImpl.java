package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PlanResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Plan;
import com.aiProjectBuilder.aiProjectBuilder.mapper.PlanResponseMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.PlanRepository;
import com.aiProjectBuilder.aiProjectBuilder.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    PlanRepository planRepository;
    PlanResponseMapper planResponseMapper;

    @Override
    public List<PlanResponse> getAllActivePlans() {
        List<Plan> plans = planRepository.findAll();
        return plans.stream().map(plan -> planResponseMapper.toPlanResponse(plan)).toList();
    }
}
