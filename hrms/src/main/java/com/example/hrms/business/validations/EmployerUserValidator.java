package com.example.hrms.business.validations;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.ValidationService;
import com.example.hrms.entities.concretes.EmployerUser;

@Service
public class EmployerUserValidator implements ValidationService<EmployerUser> {

	@Override
	public boolean isValid(EmployerUser employerUser) {

		boolean result = employerUser.getCompanyName().isBlank()
				|| employerUser.getPhone().isBlank()
				|| employerUser.getWebAddress().isBlank()
				|| employerUser.getEmailAddress().isBlank()
				|| employerUser.getPassword().isBlank();
		if (result) {
			return false;
		}
		
		return true;
	}

}
