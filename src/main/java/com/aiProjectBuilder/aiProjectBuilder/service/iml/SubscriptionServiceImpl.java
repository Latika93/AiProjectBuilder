package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PortalResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.SubscriptionResponse;
import com.aiProjectBuilder.aiProjectBuilder.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

}
