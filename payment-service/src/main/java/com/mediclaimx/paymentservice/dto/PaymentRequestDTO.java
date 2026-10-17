package com.mediclaimx.paymentservice.dto;

import com.mediclaimx.paymentservice.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {

    private Long billId;

    private Long claimId;

    private Long patientId;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private String remarks;
}