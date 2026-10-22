package com.mediclaimx.patientservice.service;

import com.mediclaimx.patientservice.event.PatientRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientEventPublisher {

    private final KafkaTemplate<String,
                PatientRegisteredEvent>
            kafkaTemplate;

    public void publishPatientRegistered(
            PatientRegisteredEvent event) {

        kafkaTemplate.send(
                "patient-registered",
                event);
    }
}