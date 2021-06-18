package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.ConfirmEmployer;

public interface ConfirmEmployerService {

	DataResult<ConfirmEmployer> getByEmployer_Id(int id);
	
	boolean existsByEmployer_Id(int id);
	
}
