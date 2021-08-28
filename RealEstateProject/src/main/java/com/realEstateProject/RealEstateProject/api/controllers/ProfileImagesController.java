package com.realEstateProject.RealEstateProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.business.abstracts.ProfileImageService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.ProfileImage;

@RestController
@RequestMapping("/api/profileImages/")
@CrossOrigin
public class ProfileImagesController {

	private ProfileImageService profileImageService;
	
	@Autowired
	public ProfileImagesController(ProfileImageService profileImageService) {
		super();
		this.profileImageService = profileImageService;
	}
	
	@PostMapping("add")
	public Result addProfileImage(@RequestParam int userId, @RequestPart("multipartFile") MultipartFile multipartFile) {
		return this.profileImageService.addProfileImage(userId, multipartFile);
	}
	
	@PostMapping("update")
	public Result updateProfileImage(@RequestParam int userId, @RequestPart("MultipartFile") MultipartFile multipartFile) {
		return this.profileImageService.updateProfileImage(userId, multipartFile);
	}
	
	@GetMapping("getProfileImageByUserId")
	public DataResult<ProfileImage> getProfileImageByUserId(@RequestParam int userId) {
		return this.profileImageService.getProfileImageByUserId(userId);
	}
}
