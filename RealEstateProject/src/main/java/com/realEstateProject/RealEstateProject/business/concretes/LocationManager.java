package com.realEstateProject.RealEstateProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.LocationService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.LocationDao;
import com.realEstateProject.RealEstateProject.entities.concretes.Location;

@Service
public class LocationManager implements LocationService {

	private LocationDao locationDao;
	
	@Autowired
	public LocationManager(LocationDao locationDao) {
		super();
		this.locationDao = locationDao;
	}
	
	@Override
	public Result add(Location location) {
	
		this.locationDao.save(location);
		return new SuccessResult(Message.SAVED_MESSAGE);
	}

	@Override
	public DataResult<List<Location>> getAll() {
		
		return new SuccessDataResult<List<Location>>(this.locationDao.findAll());
	}

}
