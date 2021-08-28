package com.realEstateProject.RealEstateProject.business.abstracts;

import java.util.List;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.EstateType;

public interface EstateTypeService {
	
	Result add(EstateType estateType);
	
	DataResult<List<EstateType>> getAll();
}
