package com.mediclaimx.hospitalservice.service;

import com.mediclaimx.hospitalservice.entity.DiagnosticTest;
import com.mediclaimx.hospitalservice.enums.TestStatus;
import com.mediclaimx.hospitalservice.kafka.DiagnosticTestCompleteEventPublisher;
import com.mediclaimx.hospitalservice.repository.DiagnosticTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class DiagnosticTestService {

    private final DiagnosticTestRepository diagnosticTestRepository;
    private final DiagnosticTestCompleteEventPublisher diagnosticTestCompleteEventPublisher;
    @Transactional
    public DiagnosticTest completeTest(
            Long testId,
            String result,
            Long technicianId) {

        DiagnosticTest test = diagnosticTestRepository.findById(testId)
                        .orElseThrow(() -> new RuntimeException("Test not found"));

        test.setResult(result);
        test.setPerformedBy(technicianId);
        test.setStatus(TestStatus.COMPLETED);
        test.setCompletedAt(LocalDateTime.now());

        DiagnosticTest savedTest = diagnosticTestRepository.save(test);

        diagnosticTestCompleteEventPublisher.publishDiagnosticRecord(savedTest);

        return savedTest;
    }
}
