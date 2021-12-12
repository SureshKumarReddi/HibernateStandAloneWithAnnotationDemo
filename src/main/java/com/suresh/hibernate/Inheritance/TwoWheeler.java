package com.suresh.hibernate.Inheritance;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

	private String SteeringType;

	public String getSteeringType() {
		return SteeringType;
	}

	public void setSteeringType(String steeringType) {
		SteeringType = steeringType;
	}
	
	
}
