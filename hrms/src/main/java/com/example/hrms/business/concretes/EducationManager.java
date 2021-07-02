package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new ErrorDataResult<List<Education>>(this.educationDao.findAll(), "Data listelendi.");
		
	}

	@Override
	public Result add(Education education) {
		
		this.educationDao.save(education);
		return new SuccessResult("Eklendi.");
		
	}

	@Override
	public DataResult<List<Education>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"endedDate");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort), "Data listelendi.");
		
	}

	@Override
	public Result update(Education education) {
		
		this.educationDao.save(education);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		if (this.educationDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.educationDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<Education>> findByResumeId(int id) {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findByResumeId(id),"Data getirildi.");
		
	}

}
