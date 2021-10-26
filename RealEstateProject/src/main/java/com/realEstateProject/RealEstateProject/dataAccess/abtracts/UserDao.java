package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
