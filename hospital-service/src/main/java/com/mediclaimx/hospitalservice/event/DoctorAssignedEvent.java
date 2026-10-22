package com.mediclaimx.hospitalservice.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAssignedEvent {

    private Long visitId;

    private Long doctorId;

    private Long patientId;
}