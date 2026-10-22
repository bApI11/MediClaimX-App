package com.mediclaimx.hospitalservice.repository;

import com.mediclaimx.hospitalservice.entity.ConsultationQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository
        extends JpaRepository<ConsultationQueue, Long> {

    Long countByDoctorId(Long doctorId);
}