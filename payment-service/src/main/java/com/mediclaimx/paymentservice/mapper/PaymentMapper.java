package com.mediclaimx.paymentservice.mapper;

import com.mediclaimx.paymentservice.dto.PaymentRequestDTO;
import com.mediclaimx.paymentservice.dto.PaymentResponseDTO;
import com.mediclaimx.paymentservice.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment toEntity(PaymentRequestDTO paymentRequestDTO) {

        return Payment.builder()
                .billId(paymentRequestDTO.getBillId())
                .claimId(paymentRequestDTO.getClaimId())
                .patientId(paymentRequestDTO.getPatientId())
                .amount(paymentRequestDTO.getAmount())
                .paymentMethod(paymentRequestDTO.getPaymentMethod())
                .remarks(paymentRequestDTO.getRemarks())
                .build();
    }
    public PaymentResponseDTO toResponseDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .paymentId(payment.getId())
                .billId(payment.getBillId())
                .claimId(payment.getClaimId())
                .patientId(payment.getPatientId())
                .transactionId(payment.getTransactionId())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .remarks(payment.getRemarks())
                .paymentDate(payment.getPaymentDate())
                .build();

    }
}
