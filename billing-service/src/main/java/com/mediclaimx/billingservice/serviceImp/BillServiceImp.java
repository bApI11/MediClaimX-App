package com.mediclaimx.billingservice.serviceImp;

import com.mediclaimx.billingservice.dto.BillRequestDTO;
import com.mediclaimx.billingservice.dto.BillResponseDTO;
import com.mediclaimx.billingservice.service.BillService;

import java.util.List;

public class BillServiceImp implements BillService {
    @Override
    public BillResponseDTO createBill(BillRequestDTO requestDto) {

        return null;
    }

    @Override
    public BillResponseDTO getBillById(Long billId) {
        return null;
    }

    @Override
    public List<BillResponseDTO> getAllBills() {
        return List.of();
    }

    @Override
    public BillResponseDTO updateBill(Long billId, BillRequestDTO requestDto) {
        return null;
    }

    @Override
    public void deleteBill(Long billId) {

    }
}
