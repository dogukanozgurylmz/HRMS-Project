package com.example.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.cloudinary.CloudinaryImageService;
import com.example.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeGetDto;
import com.example.hrms.entities.dtos.ResumePostDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private CloudinaryImageService imageService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryImageService imageService, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.imageService = imageService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		
		//var result = this.dtoConverterService.dtoConverter(this.resumeDao.findAll(), ResumeGetDto.class);
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Data listelendi.");
	
	}

	@Override
	public Result add(Resume resume) {
		
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resume, Resume.class));
		return new SuccessResult("Kayıt Başarılı");
		
	}

	@Override
	public Result saveImage( MultipartFile file, int resumeId) {
		
		@SuppressWarnings("unchecked")
		var result = resumeDao.getOne(resumeId);
        Map<String, String> upload = (Map<String, String>) imageService.saveImage(file).getData();
        result.setPhoto(upload.get("url"));
        resumeDao.save(result);
        return new SuccessResult("Resim yüklendi");
        
	}

	@Override
	public DataResult<List<Resume>> findAllByCandidateUserId(int id) {
		
		var result = this.resumeDao.findAllByCandidateUserId(id);
		return new SuccessDataResult<List<Resume>>(result,"Data listelendi.");
		
	}

	@Override
	public Result update(Resume resumeToUpdate) {
		
		this.resumeDao.save(resumeToUpdate);
		return new SuccessResult("Güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		
		if (this.resumeDao.getOne(id).equals(null)) {
			return new ErrorResult("Başarısız");
		}
		this.resumeDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<Resume> getById(int id) {
		
		var result = this.resumeDao.findById(id);
		if (result==null) {
			return new ErrorDataResult<Resume>("Başarısız");
		}
		return new SuccessDataResult<Resume>(result,"Data getirildi");
		
	}
	
}
