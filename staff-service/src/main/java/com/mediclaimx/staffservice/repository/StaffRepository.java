package com.mediclaimx.staffservice.repository;

import com.mediclaimx.staffservice.entity.Staff;
import com.mediclaimx.staffservice.enums.StaffRole;
import com.mediclaimx.staffservice.enums.StaffStatus;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);
    Optional<Staff> findByPhone(String phone);
    List<Staff> findAllByRole(StaffRole role);
    List<Staff> findAllByStatus(StaffStatus status);
    boolean existsByEmail(String email);
    Optional<Staff> findByName(String name);

    Optional<Staff> findByEmailIgnoreCaseOrPhone(String email, String phone);
}