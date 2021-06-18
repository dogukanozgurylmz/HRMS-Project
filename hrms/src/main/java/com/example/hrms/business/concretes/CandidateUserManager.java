package com.example.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.business.abstracts.UserCheckService;
import com.example.hrms.business.abstracts.UsersVerifyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.User;

@Service
public class CandidateUserManager implements CandidateUserService {
	
	private CandidateUserDao candidateUserDao;
	private UserDao userDao;
	private UsersVerifyService usersVerifyService;
	private UserCheckService checkService;
	
	@Autowired
	public CandidateUserManager(CandidateUserDao candidateUserDao,
			UserDao userDao,
			UsersVerifyService usersVerifyService,
			UserCheckService checkService) {
		
		this.candidateUserDao = candidateUserDao;
		this.checkService = checkService;
		this.userDao = userDao;
		this.usersVerifyService = usersVerifyService;
	}

	@Override
	public DataResult<List<CandidateUser>> getAll() {
		
		var result = candidateUserDao.findAll();
		return new SuccessDataResult<List<CandidateUser>>(result,"İş arayanlar listelendi.");
		
	}

	@Override
	public Result add(CandidateUser candidateUser) {
		
		if (!candidateUserDao.getByNationalIdentity(candidateUser.getNationalIdentity()).equals(null)) {
			return new ErrorResult("TC Kimlik Numarası zaten kayıtlı.");
		}
		if (!userDao.getByEmailAddress(candidateUser.getEmailAddress()).equals(null)) {
			return new ErrorResult("Bu e-posta adresi zaten kayıtlı.");
		}
		candidateUserDao.save(candidateUser);
		
		return new SuccessResult("Kaydedildi.");
		
	}

	@Override
	public Result update(CandidateUser candidateUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(CandidateUser candidateUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
