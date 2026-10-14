package com.mediclaimx.billingservice.dto;


import com.mediclaimx.billingservice.enums.BillStatus;
import com.mediclaimx.billingservice.enums.BillType;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillResponseDTO {

    private Long billId;

    private Long claimId;

    private Long patientId;

    private Long policyId;

    private BillType billType;

    private BillStatus billStatus;

    private BigDecimal totalAmount;

    private BigDecimal insuranceCoveredAmount;

    private BigDecimal patientPayableAmount;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}