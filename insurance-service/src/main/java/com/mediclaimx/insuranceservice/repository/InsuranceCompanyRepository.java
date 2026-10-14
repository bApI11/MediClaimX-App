package com.mediclaimx.insuranceservice.repository;

import com.mediclaimx.insuranceservice.entity.InsuranceCompany;
import com.mediclaimx.insuranceservice.enums.InsuranceCompanyStatus;
import com.mediclaimx.insuranceservice.enums.InsuranceCompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {
    Optional<InsuranceCompany> findByCode(String code);
    Optional<InsuranceCompany> findByEmail(String email);
    Optional<InsuranceCompany> findByPhone(String phone);
    Optional<InsuranceCompany> findByLicenseNumber(String licenseNumber);
    Optional<InsuranceCompany> findByTaxId(String taxId);
    List<InsuranceCompany> findByNameContainingIgnoreCase(String name);
    List<InsuranceCompany> findByType(InsuranceCompanyType type);
    List<InsuranceCompany> findByStatus(InsuranceCompanyStatus status);
    List<InsuranceCompany> findByCity(String city);
    List<InsuranceCompany> findByState(String state);
    List<InsuranceCompany> findByCountry(String country);

    @Query("SELECT ic FROM InsuranceCompany ic WHERE ic.networkHospitals LIKE %:hospitalName%")
    List<InsuranceCompany> findByNetworkHospital(@Param("hospitalName") String hospitalName);

    boolean existsByCode(String code);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByTaxId(String taxId);
}