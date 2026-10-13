package com.mediclaimx.patientservice.dto;

import com.mediclaimx.patientservice.enums.BloodGroup;
import com.mediclaimx.patientservice.enums.Gender;
import com.mediclaimx.patientservice.enums.PatientStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private BloodGroup bloodGroup;
    private String medicalHistory;
    private String allergies;
    private String currentMedications;
    private PatientStatus status;
}