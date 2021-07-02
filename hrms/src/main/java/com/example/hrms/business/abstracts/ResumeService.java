package com.example.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeGetDto;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	
	DataResult<List<Resume>> findAllByCandidateUserId(int id);
	
	DataResult<Resume> getById(int id);
	
	Result add(Resume resume);
	
	Result update(Resume resumeToUpdate);
	
	Result delete(int id);
	
	Result saveImage(MultipartFile file, int resumeId );
	
}
