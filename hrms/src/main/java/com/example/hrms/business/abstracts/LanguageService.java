package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	
	DataResult<List<Language>> findByResumeId(int id);
	
	Result add(Language language);
	
	Result update(Language language);
	
	Result delete(int id);
	
}
