
package com.mediclaimx.paymentservice.entity;

import com.mediclaimx.paymentservice.enums.PaymentMethod;
import com.mediclaimx.paymentservice.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long billId;

    private Long patientId;

    private Long claimId;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(unique = true)
    private String transactionId;

    private String remarks;

    private LocalDateTime paymentDate;
}
