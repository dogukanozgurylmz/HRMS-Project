package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;

public interface ResumeService {

	DataResult<List<Resume>> getAll();
	
	Result add(Resume resume);
	
}
