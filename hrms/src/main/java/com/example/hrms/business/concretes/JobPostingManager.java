package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		var result = this.jobPostingDao.findAll();
		return new SuccessDataResult<List<JobPosting>>(result, "İş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {

		var result = this.jobPostingDao.findByIsActive();
		return new SuccessDataResult<List<JobPostingDto>>(result, "Aktif iş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployerUser_companyName(String companyName) {

		var result = this.jobPostingDao.findByIsActiveAndEmployerUser_CompanyName(companyName);
		return new SuccessDataResult<List<JobPostingDto>>(result, companyName.toLowerCase() + " şirketinin iş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline() {

		var result = this.jobPostingDao.findByIsActiveOrderByReleaseDate();
		return new SuccessDataResult<List<JobPostingDto>>(result, "İş ilanının süresi doldu.");

	}

	@Override
	public Result add(JobPosting jobPosting) {
		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Eklendi.");
		
	}

	@Override
	public Result update(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		return null;
	}

}
