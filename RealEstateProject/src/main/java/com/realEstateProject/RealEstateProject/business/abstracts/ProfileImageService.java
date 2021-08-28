package com.realEstateProject.RealEstateProject.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.ProfileImage;

public interface ProfileImageService {

	Result addProfileImage(int userId, MultipartFile multipartFile);
	
	Result updateProfileImage(int userId, MultipartFile multipartFile);
	
	DataResult<ProfileImage> getProfileImageByUserId(int userId);
}
