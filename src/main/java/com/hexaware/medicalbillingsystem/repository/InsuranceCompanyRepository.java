package com.hexaware.medicalbillingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;


@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {

	
	Optional<InsuranceCompany> findByCompanyName(String companyName);
}
