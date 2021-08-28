package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.business.abstracts.HouseImageService;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;


@RestController
@RequestMapping("/api/houseImages/")
@CrossOrigin
public class HouseImagesController {
	
	private HouseImageService houseImageService;
	
	@Autowired
	public HouseImagesController(HouseImageService houseImageService) {
		super();
		this.houseImageService = houseImageService;
	}
	
	@PostMapping("upload")
	public Result uploadImage(@RequestParam int houseId, @RequestPart("multipartFile") MultipartFile multipartFile) {
		return this.houseImageService.uploadImageForHouse(houseId, multipartFile);
	}
	
}
