package com.example.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.cloudinary.CloudinaryImageAdapter;
import com.example.hrms.core.cloudinary.CloudinaryImageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryImageService imageService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Data listelendi");
	
	}

	@Override
	public Result add(Resume resume) {
		
		this.resumeDao.save(resume);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result saveImage( MultipartFile file, int resumeId) {
//		Resume resume = resumeDao.getOne(resumeId);
//		Map<String,String> uploadImage = this.imageService.saveImage(file).getData();
//        resume.setPhoto(uploadImage.get("url"));
//        this.resumeDao.save(resume);
//        return new SuccessResult("Image has been successfully added.");
		
		var result = resumeDao.getOne(resumeId);
        CloudinaryImageService imageService = new CloudinaryImageAdapter();
        Map<String, String> upload = (Map<String, String>) imageService.saveImage(file).getData();
        result.setPhoto(upload.get("url"));
        resumeDao.save(result);
        return new SuccessResult("Resim yüklendi");
        
	}
	
}
