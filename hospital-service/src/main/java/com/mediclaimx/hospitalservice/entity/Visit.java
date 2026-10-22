package com.mediclaimx.hospitalservice.entity;

import java.time.LocalDateTime;

import com.mediclaimx.hospitalservice.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String visitNumber;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private Long doctorId;

    private LocalDateTime visitTime;

    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        visitTime = LocalDateTime.now();
    }
}