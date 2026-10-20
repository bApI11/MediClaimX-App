package com.mediclaimx.notificationservice.entity;

import com.mediclaimx.notificationservice.enums.NotificationStatus;
import com.mediclaimx.notificationservice.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private Long patientId;

    private String email;

    private String subject;

    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    private LocalDateTime createdDate;

}
