package com.mediclaimx.patientservice.dto;

import lombok.Data;

@Data
public class HospitalResponse {

    private Long hospitalId;

    private String hospitalName;

    private Boolean active;
}