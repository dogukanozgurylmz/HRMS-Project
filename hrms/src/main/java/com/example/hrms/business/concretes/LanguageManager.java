package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
		
	}

	@Override
	public Result add(Language language) {
		
		this.languageDao.save(language);
		return new SuccessResult("Eklendi.");
		
	}

	@Override
	public Result update(Language language) {
		
		this.languageDao.save(language);
		return new SuccessResult("Güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		
		if (this.languageDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.languageDao.deleteById(id);
		return new SuccessResult("Silindi");
		
	}

	@Override
	public DataResult<List<Language>> findByResumeId(int id) {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findByResumeId(id),"Data getirildi.");
		
	}

}
