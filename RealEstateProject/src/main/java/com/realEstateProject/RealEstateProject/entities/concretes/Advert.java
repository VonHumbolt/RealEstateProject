package com.realEstateProject.RealEstateProject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="advert")
public class Advert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advert_id")
	private int advertId;
	
	@Column(name="title")
	@NotBlank
	private String advertTitle;
	
	@Column(name="publishedAt")
	private Date publishedAt = new Date();
	
	@Column(name="is_active")
	private boolean isActive = false;
	
	@OneToOne
	@JoinColumn(name="house")
	private House house;
}
