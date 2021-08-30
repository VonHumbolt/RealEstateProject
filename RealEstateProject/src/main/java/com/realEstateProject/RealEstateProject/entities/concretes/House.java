package com.realEstateProject.RealEstateProject.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="house")
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="house_id")
	private int houseId;	
	
	@Column(name="price")
	@NotBlank
	private double price;
	
	@Column(name="area")
	@NotBlank
	private int area;
	
	@Column(name="room_number")
	@NotBlank
	private String roomNumber;
	
	@Column(name="home_age")
	private int homeAge;
	
	@Column(name="floor")
	@NotBlank
	private int floor;
	
	@Column(name="is_furnished")
	private boolean isFurnished;
	
	@Column(name="is_onSite")
	private boolean isOnSite;
	
	@Column(name="site_name")
	private String siteName;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="seller")
	private Seller seller;
	
	@OneToOne
	@JoinColumn(name="location")
	private Location location; 
	
	@ManyToOne
	@JoinColumn(name="estate_type")
	private EstateType estateType;
	
	@ManyToOne
	@JoinColumn(name="heating")
	private Heating heating;
	
	@OneToMany(mappedBy = "house")
	private List<HouseImage> houseImages;
	
	@OneToOne(mappedBy = "house")
	@JsonIgnore
	private Advert advert;
	
}
