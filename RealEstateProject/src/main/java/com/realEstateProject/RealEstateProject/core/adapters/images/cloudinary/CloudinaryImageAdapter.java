package com.realEstateProject.RealEstateProject.core.adapters.images.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.realEstateProject.RealEstateProject.core.adapters.images.abstracts.ImageUploadService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.ErrorDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageAdapter implements ImageUploadService {

	private Cloudinary cloudinary;
	
	public CloudinaryImageAdapter() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","dspea8wm4",
				"api_key", "767195529372449",
				"api_secret", "L-c0X0TJL2fBdWxm6h5jtzOFuhQ"
			));
	}
	
	
	private File convertMultipartFileToFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
		File file = new File(multipartFile.getOriginalFilename());
		
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		return file;
	}
	
	@Override
	public DataResult<Map> uploadImage(MultipartFile multipartFile) {
		
		Map imageMap = null;
		
		try {
			File imageFile = convertMultipartFileToFile(multipartFile);
			
			imageMap = this.cloudinary.uploader().upload(imageFile, ObjectUtils.emptyMap());
			
			imageFile.delete();
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			return new ErrorDataResult<Map>("Image didn't uploaded!");
		}
		
		return new SuccessDataResult<Map>(imageMap);
	}

}
