package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Data listelendi");
		
	}

	@Override
	public Result add(JobExperience jobExperience) {
		
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Eklendi.");
	}

	@Override
	public DataResult<List<JobExperience>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "endedDate");
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(sort));
	}

	@Override
	public Result update(JobExperience jobExperience) {
		
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		if (this.jobExperienceDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<JobExperience>> findByResumeId(int id) {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findByResumeIdOrderByEndedDateDesc(id),"Data getirildi.");
		
	}

}
