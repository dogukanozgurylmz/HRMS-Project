package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	DataResult<List<VerificationCode>> getAll();
	
	String createActivitionCode(User user);
	Result activateUser(String activationCode);
	VerificationCode getByCode(String code);
	
}
