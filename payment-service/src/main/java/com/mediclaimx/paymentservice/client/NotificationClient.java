package com.mediclaimx.paymentservice.client;

import com.mediclaimx.paymentservice.dto.NotificationRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping("/api/notification")
    String sendNotification(@RequestBody NotificationRequestDTO notificationRequestDTO);
}
