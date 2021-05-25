package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployeeUserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeUserDao;
import com.example.hrms.entities.concretes.EmployeeUser;

@Service
public class EmployeeUserManager implements EmployeeUserService {
	
	private EmployeeUserDao employeeUserDao;

	@Autowired
	public EmployeeUserManager(EmployeeUserDao employeeUserDao) {
		this.employeeUserDao = employeeUserDao;
	}

	@Override
	public DataResult<List<EmployeeUser>> getAll() {
		
		return new SuccessDataResult<List<EmployeeUser>>(employeeUserDao.findAll(), "İş arayanlar listelendi.");
		
	}

	@Override
	public Result add(EmployeeUser employeeUser) {
		
		
		
		employeeUserDao.save(employeeUser);
		return new SuccessResult("Başarılı");
		
	}

	@Override
	public Result update(EmployeeUser employeeUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EmployeeUser employeeUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
