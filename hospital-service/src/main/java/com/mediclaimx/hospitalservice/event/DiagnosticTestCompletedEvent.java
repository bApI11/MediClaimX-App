package com.mediclaimx.hospitalservice.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticTestCompletedEvent {

    private Long patientId;

    private Long visitId;

    private String testName;

    private String resultStatus;

    private LocalDateTime completedAt;
}