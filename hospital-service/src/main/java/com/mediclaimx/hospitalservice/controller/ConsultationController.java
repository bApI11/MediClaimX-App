package com.mediclaimx.hospitalservice.controller;

import com.mediclaimx.hospitalservice.dto.ConsultationRequest;
import com.mediclaimx.hospitalservice.entity.Consultation;
import com.mediclaimx.hospitalservice.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultations")
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<Consultation> saveConsultation(
            @RequestBody ConsultationRequest request,
            @RequestHeader("doctorId") Long doctorId) {

        return ResponseEntity.ok(
                consultationService.recordConsultation(request, doctorId));
    }
}