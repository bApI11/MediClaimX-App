package com.mediclaimx.patientservice.cache;

import com.mediclaimx.patientservice.client.HospitalClient;
import com.mediclaimx.patientservice.dto.HospitalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final HospitalClient  hospitalClient;
    @Cacheable(value= "hospitalCache",key = "#hospitalId")
    public HospitalResponse getHospital(Long hospitalId){
        return hospitalClient.getHospital(hospitalId);
    }


}
