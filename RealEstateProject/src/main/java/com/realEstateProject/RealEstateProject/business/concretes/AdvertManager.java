package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.AdvertService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.AdvertDao;
import com.realEstateProject.RealEstateProject.entities.concretes.Advert;

@Service
public class AdvertManager implements AdvertService {

	private AdvertDao advertDao;
	
	@Autowired
	public AdvertManager(AdvertDao advertDao) {
		super();
		this.advertDao = advertDao;
	}
	
	@Override
	public DataResult<List<Advert>> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Advert>>(this.advertDao.getAllActiveAdvertsWithPagination(pageable));
	}

	@Override
	public DataResult<List<Advert>> getAllActiveAdvertsBySellerId(int sellerId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Advert>>(this.advertDao.getAllActiveAdvertsBySellerId(sellerId, pageable));
	}

	@Override
	public DataResult<List<Advert>> getAllActiveAdvertsBySortedDesc(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Advert>>(this.advertDao.getAllActiveAdvertsBySortedDesc(pageable));
	}

	@Override
	public Result add(Advert advert) {
		this.advertDao.save(advert);
		
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public Result delete(Advert advert) {
		this.advertDao.delete(advert);
		return new SuccessResult(Message.DELETED_MESSAGE);
	}

	@Override
	public Result update(Advert advert) {
		Advert advertFromDb = this.advertDao.findById(advert.getAdvertId()).get();
		
		advertFromDb.setAdvertTitle(advert.getAdvertTitle());
		advertFromDb.setActive(advert.isActive());
		
		this.advertDao.save(advertFromDb);
		
		return new SuccessResult(Message.UPDATED_MESSAGE);
		
	}

	@Override
	public DataResult<Advert> getAdvertByAdvertId(int advertId) {
		
		return new SuccessDataResult<Advert>(this.advertDao.getAdvertByAdvertId(advertId));
	}

	@Override
	public DataResult<List<Advert>> getAllActiveAdvertsByCityId(int cityId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Advert>>(this.advertDao.getAllActiveAdvertsByCityId(cityId, pageable));
	}

}
