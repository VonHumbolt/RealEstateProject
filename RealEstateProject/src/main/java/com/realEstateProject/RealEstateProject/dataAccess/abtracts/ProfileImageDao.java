package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realEstateProject.RealEstateProject.entities.concretes.ProfileImage;

public interface ProfileImageDao extends JpaRepository<ProfileImage, Integer> {

	ProfileImage getProfileImageByUserr_UserId(int userId);
}
