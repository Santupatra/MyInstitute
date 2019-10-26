package com.example.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String Country;
	private String Satate;

	@ManyToOne
	private Employee employee;

	public Address() {
	}
	
	

	public Address(String country, String satate) {
		super();
		Country = country;
		Satate = satate;
	}



	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", Country=" + Country + ", Satate=" + Satate + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getSatate() {
		return Satate;
	}

	public void setSatate(String satate) {
		Satate = satate;
	}
	
	@JsonIgnore
	public Employee getEmployee() {
		 return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
