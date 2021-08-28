package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.Location;

public interface LocationDao extends JpaRepository<Location, Integer>{

}
