package com.mediclaimx.hospitalservice.event;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitCreatedEvent {

    private Long visitId;

    private String visitNumber;

    private Long patientId;

    private Long hospitalId;

    private Long doctorId;

    private LocalDateTime createdAt;
}