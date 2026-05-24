package com.aiProjectBuilder.aiProjectBuilder.repository;

import com.aiProjectBuilder.aiProjectBuilder.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Override
    List<Plan> findAll();

    Optional<Plan> findByStripePriceId(String id);

}

