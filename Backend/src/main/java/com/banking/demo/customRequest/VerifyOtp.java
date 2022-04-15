package com.banking.demo.customRequest;

public class VerifyOtp {
	
	private long customerId;
	private String otp;
	
	public VerifyOtp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerifyOtp(long customerId, String otp) {
		super();
		this.customerId = customerId;
		this.otp = otp;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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
		return "VerifyOtp [customerId=" + customerId + ", otp=" + otp + "]";
	}

}
