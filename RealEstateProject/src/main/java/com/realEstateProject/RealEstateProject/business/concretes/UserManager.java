package com.realEstateProject.RealEstateProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstateProject.RealEstateProject.business.abstracts.UserService;
import com.realEstateProject.RealEstateProject.core.utilities.results.DataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.Result;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessDataResult;
import com.realEstateProject.RealEstateProject.core.utilities.results.SuccessResult;
import com.realEstateProject.RealEstateProject.dataAccess.abtracts.UserDao;
import com.realEstateProject.RealEstateProject.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	
	@Override
	public DataResult<User> getUserById(int userId) {

		return new SuccessDataResult<User>(this.userDao.findById(userId).get());
	}


	@Override
	public DataResult<User> getUserByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult();
	}
}
