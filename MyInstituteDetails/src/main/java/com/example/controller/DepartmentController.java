package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Department> DepartmentList() {
		return departmentService.getDepartmentList();
	}

	@RequestMapping(value = "/{idOrName}", method = RequestMethod.GET)
	public Optional<Department> getDepartment(@PathVariable("idOrName") String idOrName) {
		Optional<Department> department = null;
		int count = 0;
		for (int i = 0; i < idOrName.length(); i++) {
			if (!(idOrName.charAt(i) >= '0' && idOrName.charAt(i) <= '9')) {
				department = departmentService.getDepartmentByName(idOrName);
				break;
			} else {
				count++;
			}
		}
		if (count == idOrName.length()) {
			int id = Integer.parseInt(idOrName);
			department = departmentService.getDepartmentById(id);
		}
		return department;
	}

	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public void addNewDepartment(@RequestBody Department department) {
		departmentService.addNewDepartment(department);
	}

}
