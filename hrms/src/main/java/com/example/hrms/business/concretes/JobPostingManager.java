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
	public DataResult<List<JobPosting>> getByIsActiveTrue() {

		var result = this.jobPostingDao.getByIsActiveTrue();
		return new SuccessDataResult<List<JobPosting>>(result, "Aktif iş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveTrueAndEmployerUser_companyName(String companyName) {

		var result = this.jobPostingDao.getByIsActiveTrueAndEmployerUser_companyName(companyName);
		return new SuccessDataResult<List<JobPosting>>(result, companyName + " şirketinin iş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByReleaseDate() {

		var result = this.jobPostingDao.getByIsActiveTrueOrderByReleaseDate();
		return new SuccessDataResult<List<JobPosting>>(result, "İş ilanının süresi doldu.");

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
