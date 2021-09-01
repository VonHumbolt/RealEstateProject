package com.realEstateProject.RealEstateProject.business.abstracts;

import java.util.List;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAllCities();
}
