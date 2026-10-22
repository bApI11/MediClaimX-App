package com.mediclaimx.hospitalservice.repository;

import com.mediclaimx.hospitalservice.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository
        extends JpaRepository<Visit, Long> {
}