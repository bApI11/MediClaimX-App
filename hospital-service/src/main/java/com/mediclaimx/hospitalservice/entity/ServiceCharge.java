package com.mediclaimx.hospitalservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_charges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long visitId;

    private String serviceName;

    private Double amount;

    private LocalDateTime chargedAt;

    @PrePersist
    public void prePersist() {
        chargedAt = LocalDateTime.now();
    }
}