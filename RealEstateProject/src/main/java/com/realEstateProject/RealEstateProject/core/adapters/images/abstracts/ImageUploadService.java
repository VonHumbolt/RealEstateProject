package com.realEstateProject.RealEstateProject.core.adapters.images.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<Map> uploadImage(MultipartFile multipartFile); 
}
