package com.packt.webstore.domain;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String address;
	private long noOfOrdersMade;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int i) {
		this.customerId = i;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
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
