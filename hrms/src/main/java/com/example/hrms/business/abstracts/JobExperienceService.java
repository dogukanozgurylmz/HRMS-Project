package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<List<JobExperience>> getAll();
	
	DataResult<List<JobExperience>> findByResumeId(int id);
	
	DataResult<List<JobExperience>> getAllSorted();
	
	Result add(JobExperience jobExperience);
	
	Result update(JobExperience jobExperience);
	
	Result delete(int id);
	
}
