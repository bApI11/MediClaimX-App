package com.mediclaimx.hospitalservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consultation_queue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long visitId;

    private Long doctorId;

    private Integer tokenNumber;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}