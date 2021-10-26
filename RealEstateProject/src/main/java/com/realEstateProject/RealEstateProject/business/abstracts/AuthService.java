package com.realEstateProject.RealEstateProject.business.abstracts;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

public interface AuthService {
	
	DataResult<User> login(User user);
	
	DataResult<User> register(User user);
}
