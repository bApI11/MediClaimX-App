package com.mediclaimx.hospitalservice.kafka;

import com.mediclaimx.hospitalservice.entity.Consultation;
import com.mediclaimx.hospitalservice.event.TreatmentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TreatmentEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishTreatmentRecorded(Consultation consultation) {

        kafkaTemplate.send(KafkaTopics.TREATMENT_RECORDED, consultation);

                TreatmentEvent.builder()
                        .consultationId(consultation.getId())
                        .visitId(consultation.getVisitId())
                        .patientId(consultation.getPatientId())
                        .doctorId(consultation.getDoctorId())
                        .diagnosis(consultation.getDiagnosis())
                        .recordedAt(LocalDateTime.now())
                        .build();
    }
}