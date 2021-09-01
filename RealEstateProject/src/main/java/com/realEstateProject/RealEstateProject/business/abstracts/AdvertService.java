package com.realEstateProject.RealEstateProject.business.abstracts;

import java.util.List;


import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Advert;

public interface AdvertService {

	Result add(Advert advert);
	
	Result delete(Advert advert);
	
	Result update(Advert advert);
	
	DataResult<List<Advert>> getAllWithPagination(int pageNo, int pageSize);

	DataResult<List<Advert>> getAllActiveAdvertsBySellerId(int sellerId, int pageNo, int pageSize);
	
	DataResult<List<Advert>> getAllActiveAdvertsBySortedDesc(int pageNo, int pageSize);
	
	DataResult<Advert> getAdvertByAdvertId(int advertId);
	
	DataResult<List<Advert>> getAllActiveAdvertsByCityId(int cityId, int pageNo, int pageSize);
}
