package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	DataResult<List<WorkingTime>> getAll();
	
}
