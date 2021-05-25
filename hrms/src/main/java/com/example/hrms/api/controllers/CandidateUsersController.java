package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CandidateUser;

@RestController
@RequestMapping("/api/candidates")
public class CandidateUsersController {

	CandidateUserService candidateUserService;

	@Autowired
	public CandidateUsersController(CandidateUserService candidateUserService) {
		super();
		this.candidateUserService = candidateUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateUser>> getAll(){
		return candidateUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateUser candidateUser) {
		return candidateUserService.add(candidateUser);
	}
	
}
