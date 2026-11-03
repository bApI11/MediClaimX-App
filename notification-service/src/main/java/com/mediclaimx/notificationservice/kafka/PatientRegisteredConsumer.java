package com.mediclaimx.notificationservice.kafka;

import com.mediclaimx.patientservice.event.PatientRegisteredEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;

public class PatientRegisteredConsumer {

    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "patient-registered",
            groupId = "notification-group")
    public void consume(PatientRegisteredEvent event) {

        javaMailSender.sendWelcomeMail(event.getMobileNumber());
    }
}
