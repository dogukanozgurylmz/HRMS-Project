package com.example.hrms.core.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageService {

	DataResult<Map> saveImage(MultipartFile file);
	
}
