package org.demo.model;

import org.demo.customAnnotations.Init;
import org.demo.customAnnotations.JsonElement;
import org.demo.customAnnotations.JsonSerializable;

@JsonSerializable
public class Person {

	@JsonElement
	private String firstName;

	@JsonElement
	private String lastName;

	@JsonElement(key = "mailingAddress")
	private String address;

	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	//initVariables() method should be called before serialization
	@Init
	private void initVariables() {
		this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
		this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
	}
	
	public Person(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

}
