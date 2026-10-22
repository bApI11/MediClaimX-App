package com.mediclaimx.hospitalservice.cache;

import com.mediclaimx.hospitalservice.feign.PatientClient;
import com.mediclaimx.hospitalservice.feign.StaffClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueCacheService {

    private final PatientClient  patientClient;
    private final StaffClient staffClient;

    @Cacheable(value = "departmentCache", key = "#departmentId")
    public DepartmentResponse getDepartment(Long departmentId) {

        return hospitalRepositoryApi
                .getDepartment(departmentId);
    }
    @Cacheable(value = "queueSummary", key = "#doctorId")
    public QueueSummary getQueueSummary(Long doctorId) {

        return queueRepository
                .getQueueSummary(doctorId);
    }
}
