package com.mediclaimx.hospitalservice.repository;

import java.util.List;

import com.mediclaimx.hospitalservice.entity.DiagnosticTest;
import com.mediclaimx.hospitalservice.enums.TestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest, Long> {

    List<DiagnosticTest> findByPatientId(Long patientId);

    List<DiagnosticTest> findByVisitId(Long visitId);

    List<DiagnosticTest> findByStatus(TestStatus status);
}