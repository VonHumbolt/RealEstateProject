package com.realEstateProject.RealEstateProject.business.abstracts;

import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

public interface UserService {

	DataResult<User> getUserById(int userId);
	
	DataResult<User> getUserByEmail(String email);
	
	Result add(User user);
}
