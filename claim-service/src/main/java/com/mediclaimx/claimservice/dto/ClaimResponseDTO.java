package com.mediclaimx.claimservice.dto;

import com.mediclaimx.claimservice.enums.ClaimStatus;
import com.mediclaimx.claimservice.enums.ClaimType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimResponseDTO {
    private Long id;
    private String claimNumber;
    private Long patientId;
    private Long hospitalId;
    private Long insuranceCompanyId;
    private Long staffId;
    private ClaimType type;
    private ClaimStatus status;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String diagnosis;
    private String treatment;
    private BigDecimal totalAmount;
    private BigDecimal coveredAmount;
    private BigDecimal patientResponsibility;
    private String description;
    private String documents;
    private String notes;
    private String rejectionReason;
    private LocalDate claimDate;
    private LocalDate processedDate;
    private LocalDate approvedDate;
    private LocalDate rejectedDate;
    private LocalDate paidDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}