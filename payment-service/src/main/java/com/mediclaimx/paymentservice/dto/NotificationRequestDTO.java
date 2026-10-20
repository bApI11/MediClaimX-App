package com.mediclaimx.paymentservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequestDTO {

    private Long patientId;
    private String email;
    private String subject;
    private String message;

}
