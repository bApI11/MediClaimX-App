package com.mediclaimx.staffservice.service;

import com.mediclaimx.staffservice.config.StaffPrincipal;
import com.mediclaimx.staffservice.dto.LoginRequestDTO;
import com.mediclaimx.staffservice.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${jwt.expiration-ms:900000}")
    private long expirationMs;

    public LoginResponseDTO login(LoginRequestDTO request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmailOrPhone().trim(),
                                request.getPassword()
                        )
                );

        StaffPrincipal staff =
                (StaffPrincipal) authentication.getPrincipal();

        String token = jwtService.generateToken(staff);

        return LoginResponseDTO.builder()
                .token(token)
                .tokenType("Bearer")
                .id(staff.getId())
                .name(staff.getName())
                .role(staff.getStaffRole())
                .expiredTime(expirationMs/1000)
                .build();
    }
}