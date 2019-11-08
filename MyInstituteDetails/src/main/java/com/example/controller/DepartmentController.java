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

import com.example.model.Department;
import com.example.model.Employee;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Department> DepartmentList() {
		return departmentService.getDepartmentList();
	}

	@RequestMapping(value = "/{idOrName}", method = RequestMethod.GET)
	public Optional<Department> getDepartment(@PathVariable("idOrName") String idOrName) {
		Optional<Department> department = null;
		String regex = "\\d+";
		if (idOrName.matches(regex)) {
			int id = Integer.parseInt(idOrName);
			department = departmentService.getDepartmentById(id);
		} else {
			department = departmentService.getDepartmentByName(idOrName);
		}
		return department;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addNewDepartment(@RequestBody Department department) {
		departmentService.addNewDepartment(department);
	}

	@RequestMapping(value = "/{deptId}", method = RequestMethod.DELETE)
	public void deleteDepartment(@PathVariable("deptId") long id) {
		departmentService.deleteDepartment(id);
	}

//-----------------get all Employee for a particular department by department id ----
	@RequestMapping(value = "/{id}/employees", method = RequestMethod.GET)
	public List<Employee> EmployeeListByDepartmentId(@PathVariable("id") long id) {
		return departmentService.getEmployeeListByDepartmentId(id);
	}

//------------add department for a employee(both exist) ------------------------------------
	@RequestMapping(value = "/{deptId}/employees/{empId}", method = RequestMethod.POST)
	public void addEmployees(@PathVariable("empId") long empId, @PathVariable("deptId") long deptId) {
		departmentService.addEmployee(empId, deptId);
	}
}
