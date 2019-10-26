package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> EmployeeList() {
		return employeeService.getEmployeeList();
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
	public Optional<Employee> getEmployeeByName(@PathVariable("name") String name) {
		return employeeService.getEmployeeByName(name);

	}

}
