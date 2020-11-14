package com.demo.program.inheritance;

public class Medicine {

	String name;
	String address;

	public Medicine() {

	}

	public Medicine(String name, String address) {

		this.name = name;
		this.address = address;

	}

	void displayLabel() {

		System.out.println("Name of Medicine : " + name);
		System.out.println("Address of Comapany : " + address);

	}

}