package com.realEstateProject.RealEstateProject.business.abstracts;

import java.util.List;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Seller;

public interface SellerService {
	
	Result add(Seller seller);
	
	Result delete(Seller seller);
	
	Result update(Seller seller);
	
	DataResult<List<Seller>> getAll();

}
