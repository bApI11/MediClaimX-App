package com.mediclaimx.staffservice.controller;

import com.mediclaimx.staffservice.dto.LoginRequestDTO;
import com.mediclaimx.staffservice.dto.LoginResponseDTO;
import com.mediclaimx.staffservice.service.StaffAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class StaffAuthController {

    private final StaffAuthService staffAuthService;

    @PostMapping("/staff/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(
                staffAuthService.login(request)
        );
    }
}