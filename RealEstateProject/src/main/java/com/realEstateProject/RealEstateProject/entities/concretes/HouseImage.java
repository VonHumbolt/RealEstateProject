package com.realEstateProject.RealEstateProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="house_image")
public class HouseImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="house_image_id")
	private int houseImageId;

	@Column(name="house_image_path")
	private String houseImagePath;

	@ManyToOne
	@JoinColumn(name="house")
	private House house;
}
