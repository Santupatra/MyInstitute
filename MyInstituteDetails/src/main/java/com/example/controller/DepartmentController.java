package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Department> DepartmentList() {
		return departmentService.getDepartmentList();
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Optional<Department> getDepartmentById(@PathVariable("id") long id) {
		return departmentService.getDepartmentById(id);
	}

	@RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
	public Optional<Department> getDepartmentByName(@PathVariable("name") String name) {
		return departmentService.getDepartmentByName(name);
	}

}
