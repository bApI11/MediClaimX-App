package com.mediclaimx.paymentservice.repository;

import com.mediclaimx.paymentservice.entity.Payment;
import com.mediclaimx.paymentservice.enums.PaymentMethod;
import com.mediclaimx.paymentservice.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findById(long paymentId);

    List<Payment> findByPatientId(Long patientId);

    List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);

    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);

    List<Payment> findByClaimId(Long claimId);

    List<Payment> findByBillId(Long billId);

    Optional<Payment> findByTransactionId(String transactionId);

    Boolean existsByTransactionId(String transactionId);

    @Query("SELECT p from Payment p where p.claimId =:claimId and p.paymentStatus =:status")
    List<Payment> findByClaimIdAndPaymentStatus(@Param("claimId") Long claimId,@Param("status") PaymentStatus paymentStatus);


}
