package com.mediclaimx.hospitalservice.kafka;

import com.mediclaimx.hospitalservice.entity.DiagnosticTest;
import com.mediclaimx.hospitalservice.event.DiagnosticTestCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.tools.Diagnostic;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiagnosticTestCompleteEventPublisher {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishDiagnosticRecord(DiagnosticTest diagnostic) {

        DiagnosticTestCompletedEvent event = DiagnosticTestCompletedEvent.builder()

                .testName(diagnostic.getTestName())
                .patientId(diagnostic.getPatientId())
                .visitId(diagnostic.getVisitId())
                .resultStatus(diagnostic.getStatus().name())
                .completedAt(diagnostic.getCompletedAt())
                .build();
        kafkaTemplate.send(KafkaTopics.DIAGNOSTIC_TEST_COMPLETED,event.toString());
        log.info("DiagnosticTestCompletedEventPublisher publishDiagnosticRecord :{}" , event.toString());
    }
}
