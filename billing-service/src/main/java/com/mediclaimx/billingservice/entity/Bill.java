package com.mediclaimx.billingservice.entity;

import com.mediclaimx.billingservice.enums.BillStatus;
import com.mediclaimx.billingservice.enums.BillType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Long claimId;

    private Long patientId;

    private Long policyId;

    @Enumerated(EnumType.STRING)
    private BillType billType;

    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;

    private BigDecimal totalAmount;

    private BigDecimal insuranceCoveredAmount;

    private BigDecimal patientPayableAmount;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}