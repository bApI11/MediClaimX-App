package com.mediclaimx.hospitalservice.service;

import com.mediclaimx.hospitalservice.dto.CreateVisitRequest;
import com.mediclaimx.hospitalservice.dto.PatientResponse;
import com.mediclaimx.hospitalservice.dto.StaffResponse;
import com.mediclaimx.hospitalservice.dto.VisitResponseDTO;
import com.mediclaimx.hospitalservice.entity.ConsultationQueue;
import com.mediclaimx.hospitalservice.entity.Visit;
import com.mediclaimx.hospitalservice.enums.VisitStatus;
import com.mediclaimx.hospitalservice.feign.PatientClient;
import com.mediclaimx.hospitalservice.feign.StaffClient;
import com.mediclaimx.hospitalservice.kafka.VisitEventPublisher;
import com.mediclaimx.hospitalservice.repository.QueueRepository;
import com.mediclaimx.hospitalservice.repository.VisitRepository;
import com.mediclaimx.hospitalservice.util.VisitNumberGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService {

    private final VisitRepository visitRepository;
    private final QueueRepository queueRepository;

    private final PatientClient  patientClient;
    private final StaffClient staffClient;

    private final VisitNumberGenerator visitNumberGenerator;
    private final VisitEventPublisher visitEventPublisher;

    public VisitResponseDTO createVisit(CreateVisitRequest request){
        PatientResponse patient= patientClient.getPatient(request.getPatientId());
        StaffResponse staff= staffClient.getDoctorByDepartment(request.getDepartmentId());

        Visit visit= Visit.builder()
                .visitNumber(visitNumberGenerator.generateVisitNo())
                .patientId(patient.getPatientId())
                .doctorId(staff.getStaffId())
                .createdAt(LocalDateTime.now())
                .status(VisitStatus.IN_QUEUE)
                .build();

        Visit saveedVisit= visitRepository.save(visit);
        ConsultationQueue queue = new  ConsultationQueue();
        queue.setVisitId(saveedVisit.getId());
        queue.setDoctorId(staff.getStaffId());
        queue.setTokenNumber(generateTokenNo(staff.getStaffId()));
        queue.setCreatedAt(LocalDateTime.now());
        queueRepository.save(queue);
        visitEventPublisher.publishVisitCreated(saveedVisit);
        visitEventPublisher.publishDoctorAssigned(saveedVisit);

        return toVisitResponseDTO(saveedVisit);
    }
    private Integer generateTokenNo(
            Long doctorId) {

        return queueRepository
                .countByDoctorId(doctorId)
                .intValue() + 1;
    }
    private VisitResponseDTO toVisitResponseDTO(Visit visit){
        VisitResponseDTO visitResponseDTO= VisitResponseDTO.builder()
                .id(visit.getId())
                .visitNumber(visit.getVisitNumber())
                .patientId(visit.getPatientId())
                .hospitalId(visit.getHospitalId())
                .doctorId(visit.getDoctorId())
                .visitTime(visit.getVisitTime())
                .status(visit.getStatus())
                .build();
        return visitResponseDTO;
    }
}
