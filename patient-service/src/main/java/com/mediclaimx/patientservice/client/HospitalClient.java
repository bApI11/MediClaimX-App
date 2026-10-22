package com.mediclaimx.patientservice.client;

import com.mediclaimx.patientservice.dto.HospitalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hospital-service")
public interface HospitalClient {

    @GetMapping("/api/hospitals/{id}")
    HospitalResponse getHospital(
            @PathVariable Long id);

}