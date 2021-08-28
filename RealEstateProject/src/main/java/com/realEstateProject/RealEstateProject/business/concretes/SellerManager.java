package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.SellerService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.SellerDao;
import com.realEstateProject.RealEstateProject.entities.concretes.Seller;

@Service
public class SellerManager implements SellerService{

	private SellerDao sellerDao;
	
	@Autowired
	public SellerManager(SellerDao sellerDao) {
		super();
		this.sellerDao = sellerDao;
	}
	
	@Override
	public Result add(Seller seller) {
		this.sellerDao.save(seller);
		
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public Result delete(Seller seller) {
		this.sellerDao.delete(seller);
		return new SuccessResult(Message.DELETED_MESSAGE);
	}

	@Override
	public Result update(Seller seller) {
		
		Seller sellerFromDb = this.sellerDao.getById(seller.getUserId());
		sellerFromDb.setEmail(seller.getEmail());
		sellerFromDb.setFirstName(seller.getFirstName());
		sellerFromDb.setLastName(seller.getLastName());
		sellerFromDb.setPhoneNumber(seller.getPhoneNumber());
		
		return new SuccessResult(Message.UPDATED_MESSAGE);
	}

	@Override
	public DataResult<List<Seller>> getAll() {
		
		return new SuccessDataResult<List<Seller>>(this.sellerDao.findAll());
	}

}
