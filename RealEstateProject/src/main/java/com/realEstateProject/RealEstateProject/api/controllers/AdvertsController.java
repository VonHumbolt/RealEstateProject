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

import com.realEstateProject.RealEstateProject.business.abstracts.AdvertService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Advert;

@RestController
@RequestMapping("/api/adverts/")
@CrossOrigin
public class AdvertsController {

	private AdvertService advertService;
	
	@Autowired
	public AdvertsController(AdvertService advertService){
		super();
		this.advertService = advertService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Advert>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.advertService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("getBySellerId")
	public DataResult<List<Advert>> getAllActiveAdvertsBySellerId(@RequestParam int sellerId, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.advertService.getAllActiveAdvertsBySellerId(sellerId, pageNo, pageSize);
	}
	
	@GetMapping("getallBySortedDesc")
	public DataResult<List<Advert>> getAllActiveAdvertsBySortedDesc(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.advertService.getAllActiveAdvertsBySortedDesc(pageNo, pageSize);
	}

	@GetMapping("getAdvertById")
	public DataResult<Advert> getAdvertByAdvertId(@RequestParam int advertId) {
		return this.advertService.getAdvertByAdvertId(advertId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Advert advert) {
		return this.advertService.add(advert);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody Advert advert) {
		return this.advertService.delete(advert);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody Advert advert) {
		return this.advertService.update(advert);
	}
}
