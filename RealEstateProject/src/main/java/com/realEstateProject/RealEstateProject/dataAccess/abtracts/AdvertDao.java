package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realEstateProject.RealEstateProject.entities.concretes.Advert;
import com.realEstateProject.RealEstateProject.entities.concretes.House;

public interface AdvertDao extends JpaRepository<Advert, Integer>{

	@Query("From Advert a where a.isActive=true")
	List<Advert> getAllActiveAdvertsWithPagination(Pageable pabeable);
	
	@Query("From Advert a where a.isActive=true order by a.house.price DESC")
	List<Advert> getAllActiveAdvertsBySortedDesc(Pageable pabeable);

	@Query("From Advert a where a.isActive=true and a.house.seller.userId=:sellerId")
	List<Advert> getAllActiveAdvertsBySellerId(int sellerId, Pageable pageable);
	
	@Query("From Advert a where a.isActive=true and a.house.location.city.cityId=:cityId")
	List<Advert> getAllActiveAdvertsByCityId(int cityId, Pageable pageable);
	
	Advert getAdvertByAdvertId(int advertId);
}
