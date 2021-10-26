package com.realEstateProject.RealEstateProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realEstateProject.RealEstateProject.business.abstracts.AuthService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("login")
	public DataResult<User> login(@RequestBody User user) {
		return this.authService.login(user);
	}
	
	@PostMapping("register")
	public DataResult<User> register(@RequestBody User user) {
		return this.authService.register(user);
	}
	
}
