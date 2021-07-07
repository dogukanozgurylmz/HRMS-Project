package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.example.hrms.entities.dtos.JobPostingFilter;

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
	@GetMapping("/findbyid")
	public DataResult<JobPosting> findById(int id){
		return this.jobPostingService.findById(id);
	}
	
	@GetMapping("/getallByPage")
	DataResult<List<JobPosting>> getAll(int pageNo, int pageSize){
		return this.jobPostingService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobPosting>> findByIsActive(boolean status){
		return this.jobPostingService.findByIsActive(status);
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
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobPostingService.delete(id);
	}
	
	@GetMapping("/changeStatus")
	public Result changeStatus(int id) {
		return this.jobPostingService.changeStatus(id);
	}
	
	@PostMapping("/getByJobPostingFilter")
	public DataResult<Page<JobPosting>> getByFilter(@RequestParam int pageNo, @RequestParam int pageSize,@RequestBody JobPostingFilter jobPostingFilter) {
		return this.jobPostingService.getByFilter(pageNo, pageSize, jobPostingFilter);
	}
	
}
