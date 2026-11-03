package com.mediclaimx.hospitalservice.entity;

import java.time.LocalDateTime;

import com.mediclaimx.hospitalservice.enums.TestStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diagnostic_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long visitId;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private Long doctorId;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private String testName;

    @Column(length = 1000)
    private String testDescription;

    @Column(length = 5000)
    private String result;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TestStatus status;

     // Staff/Lab Technician ID

    private Long performedBy;

    private LocalDateTime orderedAt;

    private LocalDateTime completedAt;

    @PrePersist
    public void prePersist() {

        this.orderedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = TestStatus.ORDERED;
        }
    }
}