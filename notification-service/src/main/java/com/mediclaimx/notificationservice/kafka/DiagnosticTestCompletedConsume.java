package com.mediclaimx.notificationservice.kafka;

import com.mediclaimx.hospitalservice.event.DiagnosticTestCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DiagnosticTestCompletedConsume {

    @KafkaListener(topics="diagnostic-test-completed",groupId = "notification-group")
    public void consume(DiagnosticTestCompletedEvent event) {


        log.info("Received DiagnosticTestCompletedEvent : {}", event);

    }
}
