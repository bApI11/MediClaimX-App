package com.mediclaimx.hospitalservice.feign;

import com.mediclaimx.hospitalservice.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service")
public interface PatientClient {
    @GetMapping("/api/patients/{id}")
    PatientResponse getPatient(@PathVariable Long id);

}
