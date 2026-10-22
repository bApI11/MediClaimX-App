package com.mediclaimx.hospitalservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PatientResponse {

    private Long patientId;
    private Long phoneNumber;
    private String firstName;
    private String lastName;
}
