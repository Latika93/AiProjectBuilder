package com.aiProjectBuilder.aiProjectBuilder.controller;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.*;
import com.aiProjectBuilder.aiProjectBuilder.service.PlanService;
import com.aiProjectBuilder.aiProjectBuilder.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        Long userId = 1L;
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
            @RequestBody CheckoutRequest request
    ){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutResponse(request, userId));
    }

     @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(
            @RequestBody CheckoutRequest request
    ){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }


}
