package com.realEstateProject.RealEstateProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.UserService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

@RestController
@RequestMapping("/api/users/")
@CrossOrigin
public class UsersController {

	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("getById")
	public DataResult<User> getUserById(@RequestParam int userId){
		return this.userService.getUserById(userId);
	}
}
