package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.EstateTypeService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.EstateTypeDao;
import com.realEstateProject.RealEstateProject.entities.concretes.EstateType;

@Service
public class EstateTypeManager implements EstateTypeService {

	private EstateTypeDao estateTypeDao;
	
	@Autowired
	public EstateTypeManager(EstateTypeDao estateTypeDao) {
		super();
		this.estateTypeDao = estateTypeDao;
	}
	
	@Override
	public Result add(EstateType estateType) {
		
		this.estateTypeDao.save(estateType);
		
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public DataResult<List<EstateType>> getAll() {
		
		return new SuccessDataResult<List<EstateType>>(this.estateTypeDao.findAll());
	}

}
