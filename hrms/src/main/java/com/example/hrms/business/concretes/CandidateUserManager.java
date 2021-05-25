package com.example.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.business.abstracts.ValidationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms.entities.concretes.CandidateUser;

@Service
public class CandidateUserManager implements CandidateUserService {
	
	CandidateUserDao candidateUserDao;
	ValidationService<CandidateUser> validationService;
	
	@Autowired
	public CandidateUserManager(CandidateUserDao candidateUserDao, ValidationService<CandidateUser> validationService) {
		this.candidateUserDao = candidateUserDao;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<CandidateUser>> getAll() {
		
		var result = candidateUserDao.findAll();
		return new SuccessDataResult<List<CandidateUser>>(result,"İş arayanlar listelendi.");
		
	}

	@Override
	public Result add(CandidateUser candidateUser) {
		
		if (!validationService.isValid(candidateUser)) {
			return new ErrorResult("Başarısız");
		}
		
		candidateUserDao.save(candidateUser);
		return new SuccessResult("Başarılı");
		
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
	
	private boolean realEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

}
