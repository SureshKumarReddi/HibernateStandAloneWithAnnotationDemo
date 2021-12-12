package com.suresh.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Cat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cat_Id")
	private int id;
	@Column(name = "Cat_Name")
	private String name;

	/*
	 * @OneToMany
	 * 
	 * @Cascade(CascadeType.ALL)
	 * 
	 * 
	 * @JoinTable(name = "Cat_Dog",joinColumns = @JoinColumn(name="CAT_ID"),
	 * inverseJoinColumns = @JoinColumn(name="DOG_ID"))
	 * 
	 * 
	 * @JoinColumn(name="Cat_Dog")
	 */
	@ManyToMany
	@Cascade(CascadeType.ALL)
	private List<Dog> dogs = new ArrayList<Dog>();

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

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

}
