package com.mediclaimx.hospitalservice.dto;

import lombok.Data;

@Data
public class CreateVisitRequest {

    private Long patientId;

    private Long hospitalId;

    private Long departmentId;
}