package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.EstateType;

public interface EstateTypeDao extends JpaRepository<EstateType, Integer> {

}
