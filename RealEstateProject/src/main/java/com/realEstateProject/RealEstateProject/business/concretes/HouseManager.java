package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.HouseService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.HouseDao;
import com.realEstateProject.RealEstateProject.entities.concretes.House;

@Service
public class HouseManager implements HouseService{

	private HouseDao houseDao;
	
	@Autowired
	public HouseManager(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	@Override
	public Result add(House house) {
		
		this.houseDao.save(house);
		
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public Result delete(House house) {
		this.houseDao.delete(house);
		return new SuccessResult(Message.DELETED_MESSAGE);
	}

	@Override
	public Result update(House house) {
		House houseFromDb = this.houseDao.getById(house.getHouseId());
		houseFromDb.setArea(house.getArea());
		houseFromDb.setDescription(house.getDescription());
		houseFromDb.setEstateType(house.getEstateType());
		houseFromDb.setFloor(house.getFloor());
		
		this.houseDao.save(houseFromDb);
		
		return new SuccessResult(Message.UPDATED_MESSAGE);
	}

	@Override
	public DataResult<List<House>> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<House>>(this.houseDao.getAllActiveHouseWithPagination(pageable));
	}

	@Override
	public DataResult<List<House>> getAllActiveHouseBySellerId(int sellerId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<House>>(this.houseDao.getAllActiveHouseBySellerId(sellerId, pageable));
	}

	@Override
	public DataResult<List<House>> getAllActiveHouseBySortedDesc(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<House>>(this.houseDao.getAllActiveHouseBySortedDesc(pageable));
	}

	@Override
	public DataResult<House> getHouseByHouseId(int houseId) {
		
		return new SuccessDataResult<House>(this.houseDao.getById(houseId));
	}
	
}
