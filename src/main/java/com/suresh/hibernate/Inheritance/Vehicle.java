package com.suresh.hibernate.Inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE) //for tableperclassstrategy use TABLE as Primary Key generation to avoid  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Vehicle_Id")
	private int id;
	@Column(name = "Vehicle_Name")
	private String name;

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

}
