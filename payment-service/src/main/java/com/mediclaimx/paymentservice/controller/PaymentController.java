package com.mediclaimx.paymentservice.controller;

import com.mediclaimx.paymentservice.dto.PaymentRequestDTO;
import com.mediclaimx.paymentservice.dto.PaymentResponseDTO;
import com.mediclaimx.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO){

        PaymentResponseDTO paymentResponseDTO = paymentService.createPayment(paymentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments(){
        List<PaymentResponseDTO> paymentResponseDTO = paymentService.getAllPayments();
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id){
        paymentService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable Long id){
        PaymentResponseDTO paymentResponseDTO = paymentService.getPaymentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDTO);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<PaymentResponseDTO>> getAllPaymentsByPatientId(@PathVariable Long patientId){
        List<PaymentResponseDTO> paymentResponseDTO = paymentService.getAllPaymentsByPatientId(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDTO);
    }
    @GetMapping("/{billId}")
    public ResponseEntity<PaymentResponseDTO>  getPaymentsByBillId(@PathVariable Long billId){
        List<PaymentResponseDTO>  paymentResponseDTO = paymentService.getAllPaymentsByBillId(billId);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDTO.get(0));
    }

}
