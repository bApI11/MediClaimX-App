package com.mediclaimx.paymentservice.serviceImp;

import com.mediclaimx.paymentservice.client.NotificationClient;
import com.mediclaimx.paymentservice.dto.NotificationRequestDTO;
import com.mediclaimx.paymentservice.dto.PaymentRequestDTO;
import com.mediclaimx.paymentservice.dto.PaymentResponseDTO;
import com.mediclaimx.paymentservice.entity.Payment;
import com.mediclaimx.paymentservice.enums.PaymentStatus;
import com.mediclaimx.paymentservice.exception.PaymentNotFoundException;
import com.mediclaimx.paymentservice.mapper.PaymentMapper;
import com.mediclaimx.paymentservice.repository.PaymentRepository;
import com.mediclaimx.paymentservice.service.PaymentService;
import com.mediclaimx.paymentservice.util.TransectionIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;
    private final NotificationClient notificationClient;

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {
        if (request == null) {
            throw new RuntimeException("Payment request data must required");
        }
        Payment payment= paymentMapper.toEntity(request);
        payment.setTransactionId(TransectionIdGenerator.transectionIdGenerator());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());
        Payment savedPayment= paymentRepository.save(payment);

        NotificationRequestDTO notificationRequestDTO = NotificationRequestDTO.builder()
                .patientId(request.getPatientId())
                .email(request.getEmail())
                .subject("Payment Successful")
                .message("Your payment of Rs." + savedPayment.getAmount() + "has been received .")
                .build();
        notificationClient.sendNotification(notificationRequestDTO);

        return paymentMapper.toResponseDTO(savedPayment);
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long paymentId) {
        if (paymentId == null) {
            throw new RuntimeException("Payment ID must required");
        }
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(()->new RuntimeException("Payment ID not found"));
        return paymentMapper.toResponseDTO(payment);
    }
    @Override
    public List<PaymentResponseDTO> getAllPaymentsByPatientId(Long patientId) {
        if (patientId == null) {
            throw new RuntimeException("Patient ID must required");
        }
        List<Payment> payments = paymentRepository.findByPatientId(patientId);
        return payments.stream()
                .map(paymentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDTO> getAllPaymentsByBillId(Long billId) {
        if (billId == null) {
            throw new RuntimeException("Bill ID must required");
        }
        List<Payment> payments=paymentRepository.findByBillId(billId);
        if(payments.isEmpty()){
            throw new PaymentNotFoundException("No payment found for bill Id :"+ billId);
        }

        return payments.stream()
                .map(paymentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    public List<PaymentResponseDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(paymentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

}
