package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.EmployerUser;

public interface AuthService {
	
	Result registerEmployer(EmployerUser employerUser);
	   
	Result registerCandidate(CandidateUser candidateUser);

}
