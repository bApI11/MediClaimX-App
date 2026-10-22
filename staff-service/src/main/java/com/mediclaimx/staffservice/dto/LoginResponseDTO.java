package com.mediclaimx.staffservice.dto;

import com.mediclaimx.staffservice.enums.StaffRole;
import com.mediclaimx.staffservice.enums.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String name;
    private StaffRole role;
    private StaffStatus status;
    private String token; // For future JWT or session token support
    private Long expiredTime;
    private String tokenType;
}