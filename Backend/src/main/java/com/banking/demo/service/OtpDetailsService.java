package com.banking.demo.service;

import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.entities.OtpDetails;

public interface OtpDetailsService {

	OtpDetails findUserByCustomerId(long customerId);

	int updateOtpDetails(String generatedOtp, CustomerEntity customerId);

	OtpDetails newOtpEntry(OtpDetails otpDetails);

	

}
