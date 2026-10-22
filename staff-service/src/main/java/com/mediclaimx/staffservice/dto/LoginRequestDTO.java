package com.mediclaimx.staffservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginRequestDTO {
    @NotBlank(message = "Email or phone is required")
    private String emailOrPhone;
    @NotBlank(message = "Password is required")
    private String password;
}