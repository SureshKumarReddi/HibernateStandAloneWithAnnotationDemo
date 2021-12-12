package com.suresh.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Bank_Id")
	private int bankId;
	@Column(name="Bank_Name")
	private String name;
	@Column(name="Branch_Name")
	private String branchName;
	@ManyToMany(cascade = CascadeType.ALL)		
	@JoinTable(name="Bank_Customers",joinColumns = @JoinColumn(name="Bank_Customer"), 
			inverseJoinColumns = @JoinColumn(name="Customer_Bank"))
	private Set<Customer> customers;
	
	public Bank() {}

	public Bank(int bankId, String name, String branchName, Set<Customer> customers) {
		super();
		this.bankId = bankId;
		this.name = name;
		this.branchName = branchName;
		this.customers = customers;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", name=" + name + ", branchName=" + branchName + ", customers=" + customers
				+ "]";
	}
	
	
}
