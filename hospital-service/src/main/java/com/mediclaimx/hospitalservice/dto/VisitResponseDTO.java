package com.mediclaimx.hospitalservice.dto;

import com.mediclaimx.hospitalservice.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitResponseDTO {

    private Long id;

    @Column(unique = true)
    private String visitNumber;

    private Long patientId;

    private Long hospitalId;

    private Long doctorId;

    private LocalDateTime visitTime;

    @Enumerated(EnumType.STRING)
    private VisitStatus status;
}