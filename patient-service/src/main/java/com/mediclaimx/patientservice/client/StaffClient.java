package com.mediclaimx.patientservice.client;

import com.mediclaimx.patientservice.dto.StaffResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "staff-service")
public interface StaffClient {

    @GetMapping(
            "/api/staff/doctor/department/{departmentId}")
    StaffResponse getDoctorByDepartment(
            @PathVariable Long departmentId);
}