package com.realEstateProject.RealEstateProject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.SellerService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.Seller;

@RestController
@RequestMapping("/api/seller/")
@CrossOrigin
public class SellersController {

	private SellerService sellerService;
	
	@Autowired
	public SellersController(SellerService sellerService) {
		super();
		this.sellerService = sellerService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Seller>> getAll() {
		return this.sellerService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody Seller seller) {
		return this.sellerService.add(seller);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody Seller seller) {
		return this.sellerService.delete(seller);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody Seller seller) {
		return this.sellerService.update(seller);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
		
		Map<String, String> errors = new HashMap<String, String>();
		
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
		
		
	}
}
