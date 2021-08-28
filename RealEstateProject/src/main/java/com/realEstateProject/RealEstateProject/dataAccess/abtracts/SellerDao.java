package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.Seller;

public interface SellerDao extends JpaRepository<Seller, Integer> {
	
}
