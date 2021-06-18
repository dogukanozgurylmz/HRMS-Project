package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.business.abstracts.UsersVerifyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private UserDao userDao;
	private UsersVerifyService usersVerifyService;
	
	public EmployerUserManager(EmployerUserDao employerUserDao,
			UserDao userDao,
			UsersVerifyService usersVerifyService) {
		
		super();
		this.employerUserDao = employerUserDao;
		this.userDao = userDao;
		this.usersVerifyService = usersVerifyService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		
		return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll(), "İş verenler listelendi.");
		
	}

	@Override
	public Result add(EmployerUser employerUser) {
		
		employerUserDao.save(employerUser);
		return new SuccessResult("Kullanıcı kaydedildi.");
		
	}
	
	
	

}
