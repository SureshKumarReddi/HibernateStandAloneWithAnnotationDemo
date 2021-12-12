package com.suresh.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public
class Address{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Street_No")
	private int street_No;
	@Column(name = "Street_Name")
	private String street_Name;
	@Column(name = "City")
	private String city;
	@ManyToOne()
	@JoinColumn(name="Employee_Id")
	private Employee employee;
	
	public Address(int street_No, String street_Name, String city) {
		super();
		this.street_No = street_No;
		this.street_Name = street_Name;
		this.city = city;
	}
	
	public Address() {	}

	public int getStreet_No() {
		return street_No;
	}

	public void setStreet_No(int street_No) {
		this.street_No = street_No;
	}

	public String getStreet_Name() {
		return street_Name;
	}

	public void setStreet_Name(String street_Name) {
		this.street_Name = street_Name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street_No=" + street_No + ", street_Name=" + street_Name + ", city=" + city + "]";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	 
}