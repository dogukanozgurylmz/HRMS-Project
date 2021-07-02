package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.TechnologyDao;
import com.example.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	
	private TechnologyDao technologyDao;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll());
		
	}

	@Override
	public Result add(Technology technology) {
		
		this.technologyDao.save(technology);
		return new SuccessResult("Eklendi");
		
	}

	@Override
	public Result update(Technology technology) {
		
		this.technologyDao.save(technology);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(int id) {

		if (this.technologyDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.technologyDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<Technology>> findByResumeId(int id) {
		
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findByResumeId(id),"Data getirildi");
		
	}

}
