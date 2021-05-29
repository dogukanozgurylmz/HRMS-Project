package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobPosting>> getByIsActiveTrue(){
		return this.jobPostingService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployerUser_companyName")
	public DataResult<List<JobPosting>> getByIsActiveTrueAndEmployerUser_companyName(String companyName){
		return this.jobPostingService.getByIsActiveTrueAndEmployerUser_companyName(companyName);
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDate")
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByReleaseDate(){
		return this.jobPostingService.getByIsActiveTrueOrderByReleaseDate();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
}
