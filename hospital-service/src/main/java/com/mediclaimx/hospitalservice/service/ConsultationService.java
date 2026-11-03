package com.mediclaimx.hospitalservice.service;

import com.mediclaimx.hospitalservice.dto.ConsultationRequest;
import com.mediclaimx.hospitalservice.entity.Consultation;
import com.mediclaimx.hospitalservice.entity.Visit;
import com.mediclaimx.hospitalservice.kafka.TreatmentEventPublisher;
import com.mediclaimx.hospitalservice.repository.ConsultationRepository;
import com.mediclaimx.hospitalservice.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ConsultationService {

    private final ConsultationRepository repository;

    private final VisitRepository visitRepository;

    private final TreatmentEventPublisher publisher;

    public Consultation recordConsultation(
            ConsultationRequest request,
            Long doctorId) {

        Visit visit = visitRepository
                .findById(request.getVisitId())
                .orElseThrow(() ->
                        new RuntimeException("Visit not found"));

        if (!visit.getDoctorId().equals(doctorId)) {
            throw new RuntimeException(
                    "Unauthorized doctor");
        }

        Consultation consultation =
                Consultation.builder()
                        .visitId(visit.getId())
                        .patientId(visit.getPatientId())
                        .doctorId(doctorId)
                        .findings(request.getFindings())
                        .diagnosis(request.getDiagnosis())
                        .treatmentPlan(request.getTreatmentPlan())
                        .prescription(request.getPrescription())
                        .investigations(request.getInvestigations())
                        .build();

        Consultation saved = repository.save(consultation);

        publisher.publishTreatmentRecorded(saved);

        return saved;
    }
}