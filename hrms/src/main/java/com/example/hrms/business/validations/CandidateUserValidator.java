package com.example.hrms.business.validations;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.ValidationService;
import com.example.hrms.entities.concretes.CandidateUser;

@Service
public class CandidateUserValidator implements ValidationService<CandidateUser> {

	@Override
	public boolean isValid(CandidateUser candidateUser) {
		boolean result = candidateUser.getFirstName().isBlank()
				|| candidateUser.getLastName().isBlank()
				|| candidateUser.getNationalityIdentity().isBlank()
				|| candidateUser.getBirthOfDate().isBlank()
				|| candidateUser.getEmailAddress().isBlank()
				|| candidateUser.getPassword().isBlank();
		if (result) {
			return false;
		}
		return true;
	}

}
