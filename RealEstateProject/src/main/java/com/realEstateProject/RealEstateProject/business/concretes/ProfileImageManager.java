package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.business.abstracts.ProfileImageService;
import com.realEstateProject.RealEstateProject.business.abstracts.UserService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.adapters.images.abstracts.ImageUploadService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.ProfileImageDao;
import com.realEstateProject.RealEstateProject.entities.concretes.ProfileImage;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

@Service
public class ProfileImageManager implements ProfileImageService {

	private ProfileImageDao profileImageDao;
	private UserService userService;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public ProfileImageManager(ProfileImageDao profileImageDao, UserService userService, ImageUploadService imageUploadService) {
		super();
		this.profileImageDao = profileImageDao;
		this.userService = userService;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public Result addProfileImage(int userId, MultipartFile multipartFile) {
		
		Map uploadedImageMap = this.imageUploadService.uploadImage(multipartFile).getData();
		String uploadedImageUrl = (String) uploadedImageMap.get("url");
	
		ProfileImage profileImage = new ProfileImage();
		User userFromDb = this.userService.getUserById(userId).getData();

		profileImage.setUserr(userFromDb);
		profileImage.setProfileImagePath(uploadedImageUrl);
		
		this.profileImageDao.save(profileImage);
		
		return new SuccessResult(Message.IMAGE_UPLOAD);
	}

	@Override
	public Result updateProfileImage(int userId, MultipartFile multipartFile) {
		
		Map uploadedImageMap = this.imageUploadService.uploadImage(multipartFile).getData();
		String uploadedImageUrl = (String) uploadedImageMap.get("url");
		
		
		ProfileImage profileImageFromDb = this.profileImageDao.getProfileImageByUserr_UserId(userId);
		profileImageFromDb.setProfileImagePath(uploadedImageUrl);
		
		this.profileImageDao.save(profileImageFromDb);
		
		return new SuccessResult(Message.IMAGE_UPDATED);
	}

	@Override
	public DataResult<ProfileImage> getProfileImageByUserId(int userId) {
		
		return new SuccessDataResult<ProfileImage>(this.profileImageDao.getProfileImageByUserr_UserId(userId));
	}

	
}
