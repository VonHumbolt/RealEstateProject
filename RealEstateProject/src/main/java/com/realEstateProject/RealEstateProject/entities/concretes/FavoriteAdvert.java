package com.realEstateProject.RealEstateProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="favoite_advert")
public class FavoriteAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favorite_advert_id")
	private int favoriteAdvertId;
	

}
