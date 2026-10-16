package com.mediclaimx.billingservice.repository;

import com.mediclaimx.billingservice.entity.Bill;
import com.mediclaimx.billingservice.enums.BillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

    Bill findByBillId(Long billId);

    List<Bill> findByBillType(BillType billType);
    List<Bill> findByPolicyId(Long policyId);
  //  Bill findByPaymentId(Long paymentId);
    Bill findByPatientId(Long patientId);

    List<Bill> findByClaimId(String claimId);


}
