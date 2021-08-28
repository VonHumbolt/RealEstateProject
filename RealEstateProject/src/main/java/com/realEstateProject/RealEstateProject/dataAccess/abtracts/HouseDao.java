package com.realEstateProject.RealEstateProject.dataAccess.abtracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realEstateProject.RealEstateProject.entities.concretes.House;

public interface HouseDao extends JpaRepository<House, Integer>{
	
	@Query("From House h where h.isActive=true")
	List<House> getAllActiveHouseWithPagination(Pageable pabeable);
	
	@Query("From House h where h.isActive=true order by h.price DESC")
	List<House> getAllActiveHouseBySortedDesc(Pageable pabeable);

	@Query("From House h where h.isActive=true and h.seller.userId=:sellerId")
	List<House> getAllActiveHouseBySellerId(int sellerId, Pageable pageable);
}
