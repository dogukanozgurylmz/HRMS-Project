package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/employerusers")
public class EmployerUsersController {

	private EmployerUserService employerUserService;

	@Autowired
	public EmployerUsersController(EmployerUserService employerUserService) {
		super();
		this.employerUserService = employerUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerUser>> getAll(){
		return employerUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUser employerUser) {
		return employerUserService.add(employerUser);
	}
	
}
