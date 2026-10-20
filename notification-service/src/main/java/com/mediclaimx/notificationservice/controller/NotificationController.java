package com.mediclaimx.notificationservice.controller;

import com.mediclaimx.notificationservice.dto.NotificationRequestDTO;
import com.mediclaimx.notificationservice.repository.NotificationRepository;
import com.mediclaimx.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequestDTO notificationRequestDTO) {
        notificationService.sendNotification(notificationRequestDTO);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
