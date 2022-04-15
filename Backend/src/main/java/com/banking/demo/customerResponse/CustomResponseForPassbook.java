package com.banking.demo.customerResponse;

import java.util.List;


public class CustomResponseForPassbook {

	private List<List<String>> data;
	
	public CustomResponseForPassbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomResponseForPassbook(List<List<String>> data) {
		super();
		this.data = data;
	}


	public List<List<String>> getdata() {
		return data;
	}

	public void setdata(List<List<String>> data) {
		this.data = data;
	}

}
