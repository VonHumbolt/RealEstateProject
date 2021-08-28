package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.LocationService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Location;

@RestController
@RequestMapping("/api/location/")
@CrossOrigin
public class LocationsController {
	
	private LocationService locationService;
	
	@Autowired
	public LocationsController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Location>> getAll(){
		return this.locationService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Location location) {
		return this.locationService.add(location);
	}
	
}

