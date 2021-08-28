package com.realEstateProject.RealEstateProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estate_type")
public class EstateType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="estate_type_id")
	private int estateTypeId;
	
	@Column(name="estate_type_name")
	@NotBlank
	private String estateTypeName;
	
	@OneToMany(mappedBy = "estateType")
	@JsonIgnore
	private List<House> houses;
}
