
package com.mediclaimx.paymentservice.service;

import com.mediclaimx.paymentservice.dto.PaymentRequestDTO;
import com.mediclaimx.paymentservice.dto.PaymentResponseDTO;
import com.mediclaimx.paymentservice.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentService {

    PaymentResponseDTO createPayment(PaymentRequestDTO request);

    PaymentResponseDTO getPaymentById(Long paymentId);

    List<PaymentResponseDTO> getAllPaymentsByPatientId(Long patientId);

    List<PaymentResponseDTO> getAllPaymentsByBillId(Long billId);

    List<PaymentResponseDTO> getAllPayments();

    void deletePaymentById(Long paymentId);

}
