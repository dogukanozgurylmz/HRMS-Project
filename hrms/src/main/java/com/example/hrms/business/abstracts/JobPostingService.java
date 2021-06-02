package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	
	DataResult<List<JobPostingDto>> findByIsActive();
	
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployerUser_companyName(String companyName);
	
	DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline();
	
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
	
}
