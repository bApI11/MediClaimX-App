package com.mediclaimx.billingservice.serviceImp;

import com.mediclaimx.billingservice.dto.BillRequestDTO;
import com.mediclaimx.billingservice.dto.BillResponseDTO;
import com.mediclaimx.billingservice.entity.Bill;
import com.mediclaimx.billingservice.repository.BillRepository;
import com.mediclaimx.billingservice.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillServiceImp implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public BillResponseDTO createBill(BillRequestDTO requestDto) {

        if(requestDto!= null){
            throw new IllegalArgumentException("Bill data is null");
        }
        if(requestDto.getPatientId() == null){
            throw new IllegalArgumentException("Patient id is null");
        }
        if(requestDto.getBillType() == null){
            throw new RuntimeException("Bill type is null");
        }
        BigDecimal totalAmount = requestDto.getTotalAmount();
        BigDecimal coverAmount = requestDto.getInsuranceCoveredAmount();
        BigDecimal patientPayableAmount = requestDto.getPatientPayableAmount();

        if(totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) == 0){
            throw new RuntimeException("Total amount must be greater than zero");
        }
        if(coverAmount == null || coverAmount.compareTo(BigDecimal.ZERO) == 0){
            throw new RuntimeException("Cover amount must be greater than zero");
        }
        if (patientPayableAmount == null) {
            throw new RuntimeException("Patient payable amount must be greater than zero");
        }
        if(coverAmount.add(patientPayableAmount).compareTo(totalAmount) != 0){
            throw new RuntimeException("PatientPayable amount plus cover amount equal to total amount");
        }

        Bill bill = new Bill();
        bill.setPatientId(requestDto.getPatientId());
        bill.setPolicyId(requestDto.getPolicyId());
        bill.setClaimId(requestDto.getClaimId());
        bill.setBillType(requestDto.getBillType());
        bill.setTotalAmount(totalAmount);
        bill.setInsuranceCoveredAmount(coverAmount);
        bill.setPatientPayableAmount(patientPayableAmount);
        bill.setDescription(requestDto.getDescription());

        Bill saveBill= billRepository.save(bill);

        return convertToResponseDTO(saveBill);
    }

    @Override
    public BillResponseDTO getBillById(Long billId) {

        if(billId == null) {
            throw new RuntimeException("Bill id is required");
        }
        Optional<Bill> bill = billRepository.findById(billId);
        if(bill.isEmpty()) {
            throw new RuntimeException("Bill not found");
        }
        return convertToResponseDTO(bill.get());
    }

    @Override
    public List<BillResponseDTO> getAllBills() {

        List<Bill> bills = billRepository.findAll();
        return bills.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BillResponseDTO updateBill(Long billId, BillRequestDTO requestDto) {

        if(billId == null) {
            throw new IllegalArgumentException("Bill id is required");
        }
        if (requestDto == null) {
            throw new IllegalArgumentException("Bill data is required");
        }
        Bill exitBill = billRepository.findById(billId).
                orElseThrow(() -> new RuntimeException("Bill not found with this id"));

        if(requestDto.getPatientId() == null){
            throw new IllegalArgumentException("Patient id is required");
        }
        if(requestDto.getPolicyId() == null){
            throw new IllegalArgumentException("Policy id is required");
        }
        if(requestDto.getBillType() == null){
            throw new IllegalArgumentException("Bill type is required");
        }
        BigDecimal totalAmount = requestDto.getTotalAmount();
        BigDecimal coverAmount = requestDto.getInsuranceCoveredAmount();
        BigDecimal patientPayableAmount = requestDto.getPatientPayableAmount();

        if(totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
        if(coverAmount == null || coverAmount.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("Cover amount must be greater than zero");
        }
        if(patientPayableAmount == null || patientPayableAmount.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("Patient payable amount must be greater than zero");
        }
        if(coverAmount.add(patientPayableAmount).compareTo(totalAmount) != 0){
            throw new IllegalArgumentException("PatientPayable amount plus cover amount must be equal to total amount");
        }
        exitBill.setClaimId(requestDto.getClaimId());
        exitBill.setPatientId(requestDto.getPatientId());
        exitBill.setPolicyId(requestDto.getPolicyId());
        exitBill.setBillType(requestDto.getBillType());
        exitBill.setTotalAmount(totalAmount);
        exitBill.setInsuranceCoveredAmount(coverAmount);
        exitBill.setPatientPayableAmount(patientPayableAmount);
        exitBill.setDescription(requestDto.getDescription());

        Bill updateBill= billRepository.save(exitBill);

        return convertToResponseDTO(updateBill);
    }

    @Override
    public void deleteBill(Long billId) {
        if(billId == null) {
            throw new IllegalArgumentException("Bill id is required");
        }
        Bill bill= billRepository.findById(billId).
                orElseThrow(()-> new RuntimeException("Bill not found with this id"));
        billRepository.deleteById(billId);
    }

    @Override
    public BillResponseDTO getBillByPatientId(Long patientId) {
        if(patientId == null) {
            throw new IllegalArgumentException("Patient id is required");
        }
        Bill bill = billRepository.findByPatientId(patientId);
        return convertToResponseDTO(bill);
    }

    @Override
    public List<BillResponseDTO> getBillsByClaimNumber(String claimNumber) {
        if(claimNumber == null) {
            throw new IllegalArgumentException("Claim number is required");
        }
        List<Bill> bills= billRepository.findByClaimId(claimNumber);
        return bills.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }
    private BillResponseDTO convertToResponseDTO(Bill bill){

        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setPatientId(bill.getPatientId());
        billResponseDTO.setBillId(bill.getBillId());
        billResponseDTO.setBillType(bill.getBillType());
        billResponseDTO.setBillStatus(bill.getBillStatus());
        billResponseDTO.setDescription(bill.getDescription());
        billResponseDTO.setTotalAmount(bill.getTotalAmount());
        billResponseDTO.setInsuranceCoveredAmount(bill.getInsuranceCoveredAmount());
        billResponseDTO.setPatientPayableAmount(bill.getPatientPayableAmount());

        return billResponseDTO;
    }
}
