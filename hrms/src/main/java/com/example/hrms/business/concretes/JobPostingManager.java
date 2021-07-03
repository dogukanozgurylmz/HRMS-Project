package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;
import com.example.hrms.entities.dtos.JobPostingFilter;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		var result = this.jobPostingDao.findAll();
		return new SuccessDataResult<List<JobPosting>>(result, "İş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPosting>> findByIsActive(boolean status) {

		var result = this.jobPostingDao.findByIsActive(status);
		if (!status) {
			return new SuccessDataResult<List<JobPosting>>(result, "Pasif iş ilanları listelendi.");
		}if (status) {
			return new SuccessDataResult<List<JobPosting>>(result, "Aktif iş ilanları listelendi.");
		}
		return new ErrorDataResult<List<JobPosting>>();
		
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployerUser_companyName(String companyName) {

		var result = this.jobPostingDao.findByIsActiveAndEmployerUser_CompanyName(companyName);
		return new SuccessDataResult<List<JobPostingDto>>(result, companyName.toLowerCase() + " şirketinin iş ilanları listelendi.");

	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline() {

		var result = this.jobPostingDao.findByIsActiveOrderByApplicationDeadline();
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
	public Result delete(int id) {
		
		if (this.jobPostingDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result changeStatus(int id) {
		
		if (this.jobPostingDao.getOne(id).equals(null)) {
			return new SuccessResult("Başarısız");
		}
		var result = this.jobPostingDao.getOne(id);
		result.setActive(true);
		this.jobPostingDao.save(result);
		return new SuccessResult("Başarılı");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getById(id));
		
	}

	@Override
	public DataResult<List<JobPosting>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActive(true, pageable),"Listelendi");
		
	}

	@Override
	public DataResult<List<JobPosting>> getByFilter(int pageNo, int pageSize, JobPostingFilter jobPostingFilter) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByFilter(jobPostingFilter, pageable).getContent(),"Data getirildi.");
		
	}

}
