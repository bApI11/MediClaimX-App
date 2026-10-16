package com.mediclaimx.billingservice.service;


import com.mediclaimx.billingservice.dto.BillRequestDTO;
import com.mediclaimx.billingservice.dto.BillResponseDTO;

import java.util.List;

public interface BillService {

    BillResponseDTO createBill(BillRequestDTO requestDto);

    BillResponseDTO getBillById(Long billId);

    List<BillResponseDTO> getAllBills();

    BillResponseDTO updateBill(Long billId,
                               BillRequestDTO requestDto);

    void deleteBill(Long billId);

    BillResponseDTO getBillByPatientId(Long patientId);

    List<BillResponseDTO> getBillsByClaimNumber(String claimNumber);

}