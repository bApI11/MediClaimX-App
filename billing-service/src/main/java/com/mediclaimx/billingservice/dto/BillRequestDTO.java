package com.mediclaimx.billingservice.dto;

import com.mediclaimx.billingservice.enums.BillType;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillRequestDTO {

    private Long claimId;

    private Long patientId;

    private Long policyId;

    private BillType billType;

    private BigDecimal totalAmount;

    private BigDecimal insuranceCoveredAmount;

    private BigDecimal patientPayableAmount;

    private String description;
}