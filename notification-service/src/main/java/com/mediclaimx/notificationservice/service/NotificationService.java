package com.mediclaimx.notificationservice.service;

import com.mediclaimx.notificationservice.dto.NotificationRequestDTO;
import com.mediclaimx.notificationservice.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    void sendNotification(NotificationRequestDTO notification);
}
