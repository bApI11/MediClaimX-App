package com.mediclaimx.staffservice.dto;

import com.mediclaimx.staffservice.enums.StaffRole;
import com.mediclaimx.staffservice.enums.StaffStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StaffResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private StaffRole role;
    private StaffStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}