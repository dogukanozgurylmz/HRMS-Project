package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;

public interface EducationService {

	DataResult<List<Education>> getAll();
	
	DataResult<List<Education>> findByResumeId(int id);
	
	DataResult<List<Education>> getAllSorted();
	
	Result add(Education education);
	
	Result update(Education education);
	
	Result delete(int id);
	
}
