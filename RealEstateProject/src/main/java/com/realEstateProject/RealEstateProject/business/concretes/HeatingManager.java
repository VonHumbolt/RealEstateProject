package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.HeatingService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.HeatingDao;
import com.realEstateProject.RealEstateProject.entities.concretes.Heating;

@Service
public class HeatingManager implements HeatingService{

	private HeatingDao heatingDao;
	
	@Autowired
	public HeatingManager(HeatingDao heatingDao) {
		super();
		this.heatingDao = heatingDao;
	}

	@Override
	public Result add(Heating heating) {
	
		this.heatingDao.save(heating);
		
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public DataResult<List<Heating>> getAll() {
		
		return new SuccessDataResult<List<Heating>>(this.heatingDao.findAll());
	}
	
	
}
