package com.suresh.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private int id;
	@Column(name = "Employee_Name")
	private String name;
	@Column(name = "Employee_Salary")
	private double salary;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "Employee_Address")
//	private Address address;
	
	public Employee(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
	
	//many to one Demo
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Employee_Address", 
	joinColumns =@JoinColumn(name="Employee_Ids"),
	inverseJoinColumns = @JoinColumn(name="Employee_Address"))
	List<Address> address = new ArrayList<Address>();

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
}
