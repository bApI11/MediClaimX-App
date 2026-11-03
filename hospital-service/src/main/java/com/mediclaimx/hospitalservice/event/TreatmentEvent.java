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
public class TreatmentEvent {

    private Long consultationId;

    private Long visitId;

    private Long patientId;

    private Long doctorId;

    private String diagnosis;

    private LocalDateTime recordedAt;
}