package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CandidateUser;

public interface CandidateUserService {

	DataResult<List<CandidateUser>> getAll();
	
	Result add(CandidateUser candidateUser);
	Result update(CandidateUser candidateUser);
	Result delete(CandidateUser candidateUser);
	
}
