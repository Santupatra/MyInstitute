package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	EmployeeService employeeService;

	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	public Optional<Department> getDepartmentById(long id) {
		return departmentRepository.findById(id);
	}

	public Optional<Department> getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	public void addNewDepartment(Department department) {
		departmentRepository.save(department);
	}
}
