package com.mediclaimx.hospitalservice.repository;

import com.mediclaimx.hospitalservice.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository
        extends JpaRepository<Consultation, Long> {

    Long countByDoctorId(Long doctorId);
}