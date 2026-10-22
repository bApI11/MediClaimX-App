package com.mediclaimx.patientservice.dto;

import lombok.Data;

@Data
public class StaffResponse {

    private Long staffId;

    private String doctorName;

    private String specialization;
}