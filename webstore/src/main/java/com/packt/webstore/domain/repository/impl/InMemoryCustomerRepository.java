package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.packt.webstore.domain.Customer;


public class InMemoryCustomerRepository {
	private List<Customer> listOfCustomers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {
Customer c = new Customer();
c.setCustomerId(1);
c.setFirstName("Derek");
c.setLastName("Beck");
c.setAddress("Glasgow");
c.setNoOfOrdersMade(1);

Customer d = new Customer();
d.setCustomerId(2);
d.setFirstName("Sarah");
d.setLastName("Connor");
d.setAddress("Sanfrancisco");
d.setNoOfOrdersMade(5);

	}

	public List<Customer> getListOfCustomers() {
		return listOfCustomers;
	}

	public void setListOfCustomers(List<Customer> listOfCustomers) {
		this.listOfCustomers = listOfCustomers;
	}





}
