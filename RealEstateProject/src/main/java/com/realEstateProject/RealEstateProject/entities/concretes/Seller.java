package com.realEstateProject.RealEstateProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name="seller")
public class Seller extends User{
	
	@Column(name="phone_number")
	@NotBlank
	private String phoneNumber;
	
	@OneToMany(mappedBy = "seller")
	@JsonIgnore
	private List<House> houses;
	
}
