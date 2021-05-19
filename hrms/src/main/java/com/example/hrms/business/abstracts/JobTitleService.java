package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	List<JobTitle> getAll();
	
	void add(JobTitle jobTitle);

}
