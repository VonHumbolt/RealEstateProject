package com.realEstateProject.RealEstateProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="location_id")
	private int locationId;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="district")
	private String district;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(mappedBy = "location")
	@JsonIgnore
	private House house;
}
