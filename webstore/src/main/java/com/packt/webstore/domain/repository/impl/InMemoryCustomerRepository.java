package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfCustomers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {
		Customer c = new Customer();
		c.setCustomerId("DB");
		c.setFirstName("Derek");
		c.setLastName("Beck");
		c.setAddress("Glasgow");
		c.setNoOfOrdersMade(1);

		Customer d = new Customer();
		d.setCustomerId("SC");
		d.setFirstName("Sarah");
		d.setLastName("Connor");
		d.setAddress("Sanfrancisco");
		d.setNoOfOrdersMade(5);

		listOfCustomers.add(c);
		listOfCustomers.add(d);
	}

	public List<Customer> getAllCustomers() {
		return listOfCustomers;

	}

	public Customer getCustomerById(String CustomerId) {
		Customer customerById = null;

		for (Customer customer : listOfCustomers) {
			if (customer != null && customer.getCustomerId() != null
					&& customer.getCustomerId().equals(CustomerId)) {
				customerById = customer;
				break;
			}
		}

		if (customerById == null) {
			throw new IllegalArgumentException(
					"No customers found with the customer id: " + CustomerId);
		}

		return customerById;
	}
}
