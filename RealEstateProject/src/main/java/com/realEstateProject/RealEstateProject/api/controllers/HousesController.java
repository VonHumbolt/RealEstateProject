package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.HouseService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.House;

@RestController
@RequestMapping("/api/houses/")
@CrossOrigin
public class HousesController {

	
	private HouseService houseService;
	
	@Autowired
	public HousesController(HouseService houseService) {
		super();
		this.houseService = houseService;
	}
	
	@GetMapping("getall")
	public DataResult<List<House>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.houseService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("getBySellerId")
	public DataResult<List<House>> getAllActiveHouseBySellerId(@RequestParam int sellerId, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.houseService.getAllActiveHouseBySellerId(sellerId, pageNo, pageSize);
	}
	
	@GetMapping("getallBySortedDesc")
	public DataResult<List<House>> getAllActiveHouseBySortedDesc(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.houseService.getAllActiveHouseBySortedDesc(pageNo, pageSize);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody House house) {
		return this.houseService.add(house);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody House house) {
		return this.houseService.delete(house);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody House house) {
		return this.houseService.update(house);
	}
}
