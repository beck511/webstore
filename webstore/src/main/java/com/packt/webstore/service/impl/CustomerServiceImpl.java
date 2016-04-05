package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.repository.CustomerRepository;

public class CustomerServiceImpl {
	@Autowired
	private CustomerRepository CustomerRepository;

	public CustomerRepository getAllCustomers(){
		return CustomerRepository;
	}
	
	
	public CustomerRepository getCustomerRepository() {
		return CustomerRepository;
	}

	public void setCustomerRepository(CustomerRepository CustomerRepository) {
		this.CustomerRepository = CustomerRepository;
	}
}
