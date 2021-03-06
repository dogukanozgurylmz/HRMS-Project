package com.example.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.EmployerUser;
import com.example.hrms.entities.dtos.CandidateRegisterDto;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@Valid @RequestBody CandidateUser candidateUser) {
		
		return this.authService.registerCandidate(candidateUser);
		
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@Valid @RequestBody EmployerUser employerUser) {
		
		return this.authService.registerEmployer(employerUser);
		
	}
	
}
