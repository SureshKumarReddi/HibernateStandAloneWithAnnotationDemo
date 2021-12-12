package com.suresh.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id")
	private int customerId;
	@Column(name = "Customer_Name")
	private String customerName;
	@Column(name="Email_Id")
	private String emailId;
	@Column(name="Mobile_No")
	private long mobileNo;
	@ManyToMany(mappedBy = "customers" , fetch = FetchType.LAZY)
	private Set<Bank> banks;
	
	public Customer() {}

	public Customer(int customerId, String customerName, String emailId, long mobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + "]";
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}
	
	
}
