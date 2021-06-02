package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.User;

public interface UsersVerifyService {

	String createVerifyCode(int id);
	void sendMail(String email);
	Result verifyUser(String code);
	
}
