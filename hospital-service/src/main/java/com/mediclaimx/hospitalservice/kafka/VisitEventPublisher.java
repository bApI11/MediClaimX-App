package com.mediclaimx.hospitalservice.kafka;

import com.mediclaimx.hospitalservice.entity.Visit;
import com.mediclaimx.hospitalservice.event.DoctorAssignedEvent;
import com.mediclaimx.hospitalservice.event.VisitCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VisitEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishVisitCreated(
            Visit visit) {

        kafkaTemplate.send(
                KafkaTopics.VISIT_CREATED,

                VisitCreatedEvent.builder()
                        .visitId(visit.getId())
                        .visitNumber(
                                visit.getVisitNumber())
                        .patientId(
                                visit.getPatientId())
                        .doctorId(
                                visit.getDoctorId())
                        .createdAt(
                                LocalDateTime.now())
                        .build());
    }

    public void publishDoctorAssigned(
            Visit visit) {

        kafkaTemplate.send(
                KafkaTopics.DOCTOR_ASSIGNED,

                DoctorAssignedEvent.builder()
                        .visitId(visit.getId())
                        .doctorId(visit.getDoctorId())
                        .patientId(visit.getPatientId())
                        .build());
    }
}