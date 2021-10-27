package com.havuzentity.havuzentitty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="addresses")

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="street")
	private String street;
	
	@Column(name="neighborhood")
	private String neighborhood;
	
	@Column(name="district")
	private String district;
	
	@Column(name="city")
	private String city;
	

	public Address(String adress, String street, String neighborhood, String district, String city) {
		
		this.address = adress;
		this.street = street;
		this.neighborhood = neighborhood;
		this.district = district;
		this.city = city;
	}


}

