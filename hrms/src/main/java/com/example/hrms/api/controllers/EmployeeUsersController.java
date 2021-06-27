package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployeeUserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployeeUser;

@RestController
@RequestMapping("/api/employees")
public class EmployeeUsersController {

	private EmployeeUserService employeeUserService;

	@Autowired
	public EmployeeUsersController(EmployeeUserService employeeUserService) {
		super();
		this.employeeUserService = employeeUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployeeUser>> getAll(){
		return this.employeeUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EmployeeUser employeeUser) {
		return this.employeeUserService.add(employeeUser);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody EmployeeUser employeeUser) {
		return this.employeeUserService.update(employeeUser);
	}
	
}
