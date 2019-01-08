package com.example.demo;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	public DepartmentRepository departmentRepository;
	
	public DepartmentController(DepartmentRepository departmentRepository)
	{
		this.departmentRepository=departmentRepository;
	}
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public Department getAllDepartments()
	{
		return this.departmentRepository.findAll().get(0);
	}

	@PostMapping
	public void saveDepartment(@RequestBody Department department)
	{
		 this.departmentRepository.save(department);
	}
}
