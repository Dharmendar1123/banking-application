package com.banking.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.entities.OtpDetails;
import com.banking.demo.repository.OtpDetailsRepository;
import com.banking.demo.service.OtpDetailsService;

@Service
public class OtpDetailsServiceImpl implements OtpDetailsService{
	
	@Autowired
	OtpDetailsRepository otpDetailsRepository;


	@Override
	public OtpDetails findUserByCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return otpDetailsRepository.findUserByCustomerId(customerId);
	}

	@Override
	public int updateOtpDetails(String generatedOtp, CustomerEntity customerId) {
		// TODO Auto-generated method stub
		return otpDetailsRepository.updateOtpDetails(generatedOtp, customerId);
	}

	@Override
	public OtpDetails newOtpEntry(OtpDetails otpDetails) {
		// TODO Auto-generated method stub
		return otpDetailsRepository.save(otpDetails);
	}

	

	

}
