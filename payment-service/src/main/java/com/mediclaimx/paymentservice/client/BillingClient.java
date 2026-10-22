package com.mediclaimx.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "billing-seervice")
public class BillingClient {
    String updateBill(@RequestBody BillRequestDTO billRequestDTO) {}
}
