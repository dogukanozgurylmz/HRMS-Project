package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	
	DataResult<List<JobPosting>> getByIsActiveTrue();
	
	DataResult<List<JobPosting>> getByIsActiveTrueAndEmployerUser_companyName(String companyName);
	
	DataResult<List<JobPosting>> getByIsActiveTrueOrderByPostedDate();
	
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
	
}
