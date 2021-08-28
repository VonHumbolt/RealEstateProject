package com.realEstateProject.RealEstateProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="heating")
public class Heating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="heating_id")
	private int heatingId;

	@Column(name="heating_name")
	private String heatingName;
	
	@OneToMany(mappedBy = "heating")
	@JsonIgnore
	private List<House> houses;
}
