package com.mediclaimx.billingservice.controller;

import com.mediclaimx.billingservice.dto.BillRequestDTO;
import com.mediclaimx.billingservice.dto.BillResponseDTO;
import com.mediclaimx.billingservice.entity.Bill;
import com.mediclaimx.billingservice.service.BillService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<BillResponseDTO> createBill(@Valid @RequestBody BillRequestDTO billRequestDTO) {

        log.info("Received request to create a new bill");
        BillResponseDTO billResponseDTO = billService.createBill(billRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(billResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<BillResponseDTO>> getAllBills() {
        log.info("Received request to get all bills");
        List<BillResponseDTO> billResponseDTOs = billService.getAllBills();
        return ResponseEntity.status(HttpStatus.OK).body(billResponseDTOs);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<BillResponseDTO> getBillById(@PathVariable Long billId) {
        log.info("Received request to get bill by id {}", billId);
        return ResponseEntity.status(HttpStatus.OK).body(billService.getBillById(billId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillResponseDTO> updateBill(@PathVariable @NotBlank(message = "Bill id must required") Long id,
                                                      @Valid @RequestBody BillRequestDTO billRequestDTO) {
        log.info("Received request to update a new bill");
        BillResponseDTO billResponseDTO = billService.updateBill(id, billRequestDTO);
        log.info("Bill updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(billResponseDTO);
    }
    @DeleteMapping("/{billId}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long billId) {
        log.info("Received request to delete a bill by id {}", billId);
        billService.deleteBill(billId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/claim-number")
    public ResponseEntity<List<BillResponseDTO>> getBillByClaimNumber(@RequestParam @NotBlank(message = "Claim number must required") String claimNumber) {
        log.info("Received request to get all bills by claim number {}", claimNumber);
        List<BillResponseDTO> billResponseDTOs = billService.getBillsByClaimNumber(claimNumber);
        log.info("received all bills by claim number {}", billResponseDTOs.size());
        return ResponseEntity.ok(billResponseDTOs);
    }
    @GetMapping("/patient-number")
    public ResponseEntity<BillResponseDTO> getBillsByPatientId(@RequestParam @NotBlank(message = "Patient number must required"
                                                                ) Long patientId) {
        log.info("Received request to get all bills by patient {}", patientId);
        BillResponseDTO billResponseDTO = billService.getBillByPatientId(patientId);
        log.info("received all bills by patient {}", billResponseDTO.getBillId());
        return ResponseEntity.ok(billResponseDTO);
    }


}
