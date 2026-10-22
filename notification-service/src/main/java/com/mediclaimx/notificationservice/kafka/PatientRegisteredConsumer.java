package com.mediclaimx.notificationservice.kafka;

import com.mediclaimx.patientservice.event.PatientRegisteredEvent;
import org.springframework.kafka.annotation.KafkaListener;

public class PatientRegisteredConsumer {
    @KafkaListener(
            topics = "patient-registered",
            groupId = "notification-group")
    public void consume(
            PatientRegisteredEvent event) {

        emailService.sendWelcomeMail(
                event.getMobileNumber());
    }
}
