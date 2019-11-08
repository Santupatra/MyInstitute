package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

//-----------------get Employee list ----------------------
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Employee> EmployeeList() {
		return employeeService.getEmployeeList();
	}

//----------------get Employee By id/Name ----------------------------
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

//--------------add New Employee ---------------------------
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addNewEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
	}

//--------------delete a Employee by id --------------------
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
	}

//--------------update a Employee by id --------------------
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public void updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
	}
}
