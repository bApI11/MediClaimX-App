package com.mediclaimx.patientservice.kafka;

public final class KafkaTopics {

    private KafkaTopics() {}
    public static final String PATIENT_REGISTERED = "patient-registered";
    public static final String CLAIM_CREATED = "claim-created";
    public static final String PAYMENT_COMPLETED = "payment-completed";
}
