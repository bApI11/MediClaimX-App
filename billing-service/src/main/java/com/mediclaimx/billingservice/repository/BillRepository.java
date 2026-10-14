package com.mediclaimx.billingservice.repository;

import com.mediclaimx.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {


}
