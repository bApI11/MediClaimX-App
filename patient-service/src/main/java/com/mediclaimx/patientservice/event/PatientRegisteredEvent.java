package com.mediclaimx.patientservice.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientRegisteredEvent {

    private Long patientId;
    private String patientName;
    private String phoneNumber;
    private Long hospitalId;
    private Long doctorId;
    private LocalDateTime createdAt;
}