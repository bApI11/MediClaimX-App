package com.mediclaimx.paymentservice.util;

import java.util.UUID;

public class TransectionIdGenerator {

    private TransectionIdGenerator(){}

    public static String transectionIdGenerator(){
        return "MCX-PAY-" + UUID.randomUUID()
                .toString()
                .replace("-","")
                .substring(0,12)
                .toUpperCase();
    }
}
