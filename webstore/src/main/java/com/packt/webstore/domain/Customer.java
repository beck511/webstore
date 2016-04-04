package com.packt.webstore.domain;

public class Customer {

	private String customerId;
	private String firstName;
	private String lastName;
	private String address;
	private long noOfOrdersMade;

	public String getProductId() {
		return customerId;
	}

	public void setProductId(String productId) {
		this.customerId = productId;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public Customer() {
		super();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
}
