package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkType;

public interface WorkTypeService {

	DataResult<List<WorkType>> getAll();
	
}
