package com.banking.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.entities.OtpDetails;

public interface OtpDetailsRepository extends JpaRepository<OtpDetails, Long>{

	@Query("SELECT i FROM OtpDetails i WHERE i.customerId.customerId = ?1")
	OtpDetails findUserByCustomerId(long customerId);

	@Modifying
	@Transactional
	@Query("UPDATE OtpDetails i SET i.otp = ?1 WHERE i.customerId = ?2")
	int updateOtpDetails(String generatedOtp, CustomerEntity customerId);

	

}
