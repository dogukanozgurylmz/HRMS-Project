package com.example.hrms.core.cloudinary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageAdapter implements CloudinaryImageService {

	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	public CloudinaryImageAdapter() {
		valuesMap.put("cloud_name", "dogukanozgurylmz");
		valuesMap.put("api_key", "114183154134113");
		valuesMap.put("api_secret", "Fc1vBgzek7nNPxCT1q6UVgygmwM");
		cloudinary = new Cloudinary(valuesMap);
	}

	@Override
	public DataResult<Map> saveImage(MultipartFile file) {

		try {
            Map resultMap = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<Map>();
		
	}

}
