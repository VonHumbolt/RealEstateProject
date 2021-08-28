package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.HeatingService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Heating;

@RestController
@RequestMapping("/api/heating/")
@CrossOrigin
public class HeatingController {

	private HeatingService heatingService;
	
	@Autowired
	public HeatingController(HeatingService heatingService) {
		super();
		this.heatingService = heatingService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Heating heating) {
		return this.heatingService.add(heating);
	}
	
	@GetMapping("getall")
	public DataResult<List<Heating>> getAll() {
		return this.heatingService.getAll();
	}
}
