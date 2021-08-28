package com.realEstateProject.RealEstateProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="profile_image")
public class ProfileImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_image_id")
	private int profileImageId;
	
	@Column(name="profile_image_path")
	private String profileImagePath;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User userr;
	
}
