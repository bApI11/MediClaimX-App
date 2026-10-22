package com.mediclaimx.hospitalservice.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class VisitNumberGenerator {

    private static final AtomicLong COUNTER =
            new AtomicLong(500);

    public String generateVisitNo() {

        return "VIS-" + COUNTER.incrementAndGet();
    }
}