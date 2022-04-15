package com.banking.demo.util;

import org.springframework.stereotype.Service;

import com.banking.demo.customRequest.CustomRequestForMoneyTransfer;
import com.banking.demo.customRequest.PasswordChange;
import com.banking.demo.entities.AccountDetails;
import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.exception.InvalidRequestException;

@Service
public class Validations {

	public void registerCustomer(CustomerEntity cust) {
		
		if(cust.getFirstName().equals("")) {
			throw new InvalidRequestException("First Name Should not be Empty");
		}
		
		if(cust.getAadharNumber().length() != 12) {
			throw new InvalidRequestException("Enter a Valid Aadhar Number");
		}
		
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
		
		if(cust.getEmailId().matches(emailRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Email");
		}
		
		String mobileRegex = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}$";
		
		if(cust.getMobileNumber().matches(mobileRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Mobile Number");
		}
		
	}

	public void loginCustomer(CustomerEntity cust) {
		
		if(cust.getEmailId().equals("")) {
			throw new InvalidRequestException("Email Id should not be Empty");
		}
		if(cust.getPassword().equals("")) {
			throw new InvalidRequestException("Password should not be Empty");
		}
		
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
		
		if(cust.getEmailId().matches(emailRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Email");
		}
		
	}

	public void balanceValidation(AccountDetails accountDetails) {
		
		if(accountDetails.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Account Number should not be Empty");
		}
		
		if(accountDetails.getAccountBalance() <= 0) {
			throw new InvalidRequestException("Enter a valid Amount");
		}
		
	}

	public void updateCustomer(CustomerEntity cust) {
		
		if (cust.getCustomerId() <= 0 && Long.toString(cust.getCustomerId()) == "") {
			throw new InvalidRequestException("Customer Id is empty or invalid");
		}
		
		if (cust.getFirstName().equals("")) {
			throw new InvalidRequestException("First Name Should not be Empty");
		}
		
		if (cust.getAddress().equals("")) {
			throw new InvalidRequestException("Address should not be Empty");
		}
		
	}

	public void UpdatePassword(PasswordChange passwordChange) {
		
		if (passwordChange.getEmailId().equals("")) {
			throw new InvalidRequestException("Email Id should not be Empty");
		}
		
		if (passwordChange.getOldPassword().equals("")) {
			throw new InvalidRequestException("Old Password should not be Empty");
		}
		
		if (passwordChange.getNewPassword().equals("")) {
			throw new InvalidRequestException("New Password should not be Empty");
		}
		
		if (passwordChange.getConfirmPassword().equals("")) {
			throw new InvalidRequestException("Confirm Password should not be Empty");
		}
	}

	public void transferMoney(CustomRequestForMoneyTransfer moneyTransfer) {

		if(moneyTransfer.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Sender Account Number should not be Empty");
		}
		
		if(moneyTransfer.getUserAccountNumber().equals("")) {
			throw new InvalidRequestException("Receiver Account Number should not be Empty");
		}
		
		if(Long.toString(moneyTransfer.getAmount()).equals("")) {
			throw new InvalidRequestException("Amount should not be Empty");
		}
		
		if(moneyTransfer.getBranchName().equals("")) {
			throw new InvalidRequestException("Branch Name should not be Empty");
		}
		
		if(moneyTransfer.getIfsc().equals("")) {
			throw new InvalidRequestException("IFSC Code should not be Empty");
		}
		
		if(moneyTransfer.getTransactionPin().equals("")) {
			throw new InvalidRequestException("Transaction Pin should not be Empty");
		}
		
	}


}
