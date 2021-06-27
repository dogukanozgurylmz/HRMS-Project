package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.GraduateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.GraduateDao;
import com.example.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService {

	private GraduateDao garduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao garduateDao) {
		super();
		this.garduateDao = garduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		
		return new SuccessDataResult<List<Graduate>>(this.garduateDao.findAll(),"Data listelendi.");
		
	}

	@Override
	public Result add(Graduate graduate) {

		this.garduateDao.save(graduate);
		return new SuccessResult("Eklendi.");
	}

	@Override
	public Result update(Graduate graduate) {
		
		this.garduateDao.save(graduate);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(int id) {
		
		if (this.garduateDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.garduateDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

}
