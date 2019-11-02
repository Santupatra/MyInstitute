package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> EmployeeList() {
		return employeeService.getEmployeeList();
	}

	@RequestMapping(value = "/{idOrName}", method = RequestMethod.GET)
	public Optional<Employee> getEmployee(@PathVariable("idOrName") String idOrName) {
		Optional<Employee> employee = null;
		String regex = "\\d+";
		if (idOrName.matches(regex)) {
			int id = Integer.parseInt(idOrName);
			employee = employeeService.getEmployeeById(id);
		} else {
			employee = employeeService.getEmployeeByName(idOrName);
		}
		return employee;
	}

	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public void addNewEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
	}

	@RequestMapping(value = "/{empId}/add/department/{deptId}", method = RequestMethod.POST)
	public void addEmployees(@PathVariable("empId") long empId, @PathVariable("deptId") long deptId) {
		employeeService.addEmployee(empId, deptId);
	}
}
