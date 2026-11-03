package com.mediclaimx.hospitalservice.dto;

import lombok.Data;

@Data
public class ConsultationRequest {

    private Long visitId;

    private String findings;

    private String diagnosis;

    private String treatmentPlan;

    private String prescription;

    private String investigations;
}