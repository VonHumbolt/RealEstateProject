package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.HouseImage;

public interface HouseImageDao extends JpaRepository<HouseImage, Integer>{

}
