package com.mediclaimx.staffservice.dto;

import com.mediclaimx.staffservice.enums.StaffRole;
import com.mediclaimx.staffservice.enums.StaffStatus;
import lombok.Data;

@Data
public class StaffRequestDTO {
    private String name;
    private String email;
    private String phone;
    private StaffRole role;
    private String password;
    private StaffStatus status;
}