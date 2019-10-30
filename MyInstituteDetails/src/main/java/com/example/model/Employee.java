package com.example.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	private String email;
	private String name;
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_Id")
	private List<Address> address;

	@ManyToOne
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String name, String password, String email, List<Address> address) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", address="
				+ address + "]";
	}

	
	public Department getDepartment() {
		return department;

	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonIgnore
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}