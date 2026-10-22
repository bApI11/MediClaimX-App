package com.mediclaimx.hospitalservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StaffResponse {
    private Long staffId;
    private String firstName;
    private String lastName;
}
