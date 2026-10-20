package com.mediclaimx.notificationservice.serviceImp;

import com.mediclaimx.notificationservice.dto.NotificationRequestDTO;
import com.mediclaimx.notificationservice.entity.Notification;
import com.mediclaimx.notificationservice.enums.NotificationStatus;
import com.mediclaimx.notificationservice.repository.NotificationRepository;
import com.mediclaimx.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImp implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final JavaMailSender javaMailSender;

    @Override
    public void sendNotification(NotificationRequestDTO notificationRequestDTO) {

        log.info("Sending Notification Request to Patient :"+notificationRequestDTO.getPatientId());

        Notification notification = Notification.builder()
                .patientId(notificationRequestDTO.getPatientId())
                .email(notificationRequestDTO.getEmail())
                .subject(notificationRequestDTO.getSubject())
                .message(notificationRequestDTO.getMessage())
                .notificationType(notificationRequestDTO.getNotificationType())
                .notificationStatus(NotificationStatus.PENDING)
                .build();
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(notificationRequestDTO.getEmail());
            mailMessage.setSubject(notificationRequestDTO.getSubject());
            mailMessage.setText(notificationRequestDTO.getMessage());
            javaMailSender.send(mailMessage);
            notification.setNotificationStatus(NotificationStatus.SENT);
            notification.setCreatedDate(LocalDateTime.now());
        }catch (Exception e){
            notification.setNotificationStatus(NotificationStatus.FAILED);
            log.info("Notification Failed",e);
        }
        notificationRepository.save(notification);
    }
}
