package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.EstateTypeService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.EstateType;

@RestController
@RequestMapping("/api/estateTypes/")
@CrossOrigin
public class EstateTypesController {

	
	private EstateTypeService estateTypeService;
	
	@Autowired
	public EstateTypesController(EstateTypeService estateTypeService) {
		super();
		this.estateTypeService = estateTypeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<EstateType>> getAll() {
		
		return this.estateTypeService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody EstateType estateType) {
		return this.estateTypeService.add(estateType);
	}
	
}
