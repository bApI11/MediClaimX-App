package com.mediclaimx.notificationservice.dto;

import com.mediclaimx.notificationservice.enums.NotificationType;
import lombok.Data;

@Data
public class NotificationRequestDTO {

    private Long PatientId;

    private String email;

    private String subject;

    private String message;

    private NotificationType notificationType;
}
