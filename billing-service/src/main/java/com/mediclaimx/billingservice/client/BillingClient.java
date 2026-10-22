package com.mediclaimx.billingservice.client;

import com.mediclaimx.billingservice.dto.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface BillingClient {
    @PostMapping("/api/payment")
    String sendPaymentBill(@RequestBody PaymentRequestDTO paymentRequestDTO);
}
