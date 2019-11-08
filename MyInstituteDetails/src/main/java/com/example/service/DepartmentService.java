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
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
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

	public List<Employee> getEmployeeListByDepartmentId(long id) {
		return employeeRepository.findByDepartmentId(id);
	}

	public void addEmployee(long empId, long deptId) {
		Employee employee = employeeService.getEmployeeById(empId).get();
		List<Employee> employeeOfDepartment = new ArrayList<Employee>();
		Department department = getDepartmentById(deptId).get();
		employeeOfDepartment = department.getEmployees();
		employeeOfDepartment.add(employee);
		department.setEmployees(employeeOfDepartment);
		departmentRepository.save(department);
	}

	public void deleteDepartment(long id) {
		departmentRepository.deleteById(id);
	}
}
