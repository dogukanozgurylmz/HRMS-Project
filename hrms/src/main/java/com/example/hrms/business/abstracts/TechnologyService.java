package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;

public interface TechnologyService {

	DataResult<List<Technology>> getAll();
	
	DataResult<List<Technology>> findByResumeId(int id);
	
	Result add(Technology technology);

	Result update(Technology technology);
	
	Result delete(int id);
	
}
