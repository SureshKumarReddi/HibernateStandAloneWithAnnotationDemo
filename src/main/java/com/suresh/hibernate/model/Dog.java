package com.suresh.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Dog{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Dog_Id")
	private int id;
	@Column(name = "Dog_Name")
	private String  name;
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="Dog_Cat_Many") private Cat cat;
	 */
	
	@ManyToMany(mappedBy = "dogs")
	private List<Cat> cat = new ArrayList<Cat>();
	
	public List<Cat> getCat() {
		return cat;
	}
	public void setCat(List<Cat> cat) {
		this.cat = cat;
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
	
	/*
	 * public Cat getCat() { return cat; } public void setCat(Cat cat) { this.cat =
	 * cat; }
	 */
	 
	
	
}
