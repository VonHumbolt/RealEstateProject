package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realEstateProject.RealEstateProject.business.abstracts.HouseImageService;
import com.realEstateProject.RealEstateProject.business.abstracts.HouseService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.adapters.images.abstracts.ImageUploadService;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.HouseImageDao;
import com.realEstateProject.RealEstateProject.entities.concretes.House;
import com.realEstateProject.RealEstateProject.entities.concretes.HouseImage;

@Service
public class HouseImageManager implements HouseImageService {

	private HouseImageDao houseImageDao;
	private HouseService houseService;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public HouseImageManager(HouseImageDao houseImageDao, HouseService houseService, ImageUploadService imageUploadService) {
		super();
		this.houseImageDao = houseImageDao;
		this.houseService = houseService;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public Result uploadImageForHouse(int houseId, MultipartFile multipartFile) {
		
		Map uploadedImage = this.imageUploadService.uploadImage(multipartFile).getData();		
		String imageUrl = (String) uploadedImage.get("url");
		
		HouseImage houseImage = new HouseImage();
		House houseFromDb = this.houseService.getHouseByHouseId(houseId).getData();
		
		houseImage.setHouse(houseFromDb);
		houseImage.setHouseImagePath(imageUrl);
		
		this.houseImageDao.save(houseImage);
		
		return new SuccessResult(Message.IMAGE_UPLOAD);
	}


	
}
