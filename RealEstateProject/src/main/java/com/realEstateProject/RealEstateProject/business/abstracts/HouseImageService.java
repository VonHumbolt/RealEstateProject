package com.realEstateProject.RealEstateProject.business.abstracts;


import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.core.utilities.results.Result;

public interface HouseImageService {
	
	Result uploadImageForHouse(int houseId , MultipartFile multipartFile); 
}
