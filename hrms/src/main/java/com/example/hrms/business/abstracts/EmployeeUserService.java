package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployeeUser;

public interface EmployeeUserService {

	DataResult<List<EmployeeUser>> getAll();
	
	Result add(EmployeeUser employeeUser);
	Result update(EmployeeUser employeeUser);
	Result delete(EmployeeUser employeeUser);
	
}
