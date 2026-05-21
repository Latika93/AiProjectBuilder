package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.CheckoutResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String payload, StripeObject stripeObject, Map<String, String> signheader);
}
