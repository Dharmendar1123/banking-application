package com.banking.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OtpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private CustomerEntity customerId;
	private String otp;
	
	public OtpDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpDetails(long id, CustomerEntity customerId, String otp) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.otp = otp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpDetails [id=" + id + ", customerId=" + customerId + ", otp=" + otp + "]";
	}
	
	
}
