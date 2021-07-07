package com.example.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;
import com.example.hrms.entities.dtos.JobPostingFilter;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	
	DataResult<List<JobPosting>> getAll(int pageNo, int pageSize);
	
	DataResult<JobPosting> findById(int id);
	
	DataResult<List<JobPosting>> findByIsActive(boolean status);
	
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployerUser_companyName(String companyName);
	
	DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline();
	
	DataResult<Page<JobPosting>> getByFilter(int pageNo, int pageSize, JobPostingFilter jobPostingFilter);
	
	Result changeStatus(int id);
	
	Result add(JobPosting jobPosting);
	
	Result update(JobPosting jobPosting);
	
	Result delete(int id);
	
}
