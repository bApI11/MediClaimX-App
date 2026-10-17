package com.mediclaimx.paymentservice.dto;

import com.mediclaimx.paymentservice.enums.PaymentMethod;
import com.mediclaimx.paymentservice.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {

    private Long paymentId;

    private Long billId;

    private Long claimId;

    private Long patientId;

    private String transactionId;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private String remarks;

    private LocalDateTime paymentDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}