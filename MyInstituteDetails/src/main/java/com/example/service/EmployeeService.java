package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentService departmentService;

	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	public Optional<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	public void addNewEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void addEmployee(long empId, long deptId) {
		Employee employee = getEmployeeById(empId).get();
		List<Employee> employeeOfDepartment = new ArrayList<Employee>();
		Department department = departmentService.getDepartmentById(deptId).get();
		employeeOfDepartment = department.getEmployees();
		employeeOfDepartment.add(employee);
		department.setEmployees(employeeOfDepartment);
		departmentRepository.save(department);
	}

}
