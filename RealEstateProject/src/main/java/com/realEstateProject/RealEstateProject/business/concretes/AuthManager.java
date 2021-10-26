package com.realEstateProject.RealEstateProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.AuthService;
import com.realEstateProject.RealEstateProject.business.abstracts.UserService;
import com.realEstateProject.RealEstateProject.business.constants.Message;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.ErrorDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	
	@Autowired
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public DataResult<User> login(User user) {
		
		User userFromDb = this.userService.getUserByEmail(user.getEmail()).getData();
		
		if(userFromDb == null) {
			return new ErrorDataResult<User>(Message.USER_NOT_FOUND);
		} else {
			if(userFromDb.getPassword().matches(user.getPassword())) {
				return new SuccessDataResult<User>(userFromDb, Message.LOGIN);
			}
			return new ErrorDataResult<User>(Message.PASSWORD_OR_EMAIL_WRONG);
		}
	}

	@Override
	public DataResult<User> register(User user) {
		
		User userFromDb = this.userService.getUserByEmail(user.getEmail()).getData();
		
		if(userFromDb != null) {
			return new ErrorDataResult<User>(Message.USER_ALREADY_EXISTS);
		}
		
		this.userService.add(user);
		
		return new SuccessDataResult<User>(user, Message.REGISTERED);
	}
	
	
}
