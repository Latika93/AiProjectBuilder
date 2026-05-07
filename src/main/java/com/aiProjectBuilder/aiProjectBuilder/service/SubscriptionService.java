package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PortalResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutResponse(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
