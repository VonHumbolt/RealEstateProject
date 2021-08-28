package com.realEstateProject.RealEstateProject.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.House;

public interface HouseService {
	
	Result add(House house);
	
	Result delete(House house);
	
	Result update(House house);
	
	DataResult<List<House>> getAllWithPagination(int pageNo, int pageSize);

	DataResult<List<House>> getAllActiveHouseBySellerId(int sellerId, int pageNo, int pageSize);
	
	DataResult<List<House>> getAllActiveHouseBySortedDesc(int pageNo, int pageSize);
	
	DataResult<House> getHouseByHouseId(int houseId);
}