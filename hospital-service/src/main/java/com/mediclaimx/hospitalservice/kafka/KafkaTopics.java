package com.mediclaimx.hospitalservice.kafka;

public class KafkaTopics {
    private KafkaTopics() {}

    public static final String VISIT_CREATED = "visit-created";

    public static final String DOCTOR_ASSIGNED = "doctor-assigned";

    public static final String TREATMENT_RECORDED= "treatment-recorded";

    public static final String DIAGNOSTIC_TEST_COMPLETED = "diagnostic-test-completed";
}