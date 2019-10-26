package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	public Optional<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

}
