package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobpostings")
@CrossOrigin
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
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobPostingDto>> findByIsActive(){
		return this.jobPostingService.findByIsActive();
	}
	
	@GetMapping("/findByIsActiveAndEmployerUser_companyName")
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployerUser_companyName(String companyName){
		return this.jobPostingService.findByIsActiveAndEmployerUser_companyName(companyName);
	}
	
	@GetMapping("/findByIsActiveOrderByApplicationDeadline")
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline(){
		return this.jobPostingService.findByIsActiveOrderByApplicationDeadline();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/changeStatus")
	public Result changeStatus(int id) {
		return this.jobPostingService.changeStatus(id);
	}
	
}
