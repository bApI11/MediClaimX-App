package com.mediclaimx.patientservice.kafka;

import com.mediclaimx.patientservice.event.PatientRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientEventPublisher {

    private final KafkaTemplate<String,
                PatientRegisteredEvent> kafkaTemplate;

    public void publishPatientRegisteredEvent(
            PatientRegisteredEvent event) {

        kafkaTemplate.send(KafkaTopics.PATIENT_REGISTERED, event);

        log.info(
                "Patient Registered Event Published : {}",
                event.getPatientId());
    }
}