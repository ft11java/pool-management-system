package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Address;

import lombok.Getter;

@Getter
public final class AddressUserViewDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private final String address;
	
	private final String street;

	private final String neighborhood;
	
	private final String district;
	
	private final String city;

	
	public AddressUserViewDTO(String address, String street, String neighborhood, String district, String city) {
	
		
		this.address = address;
		this.street = street;
		this.neighborhood = neighborhood;
		this.district = district;
		this.city = city;
	}
	
	public static AddressUserViewDTO of(Address address) {
		
		return new AddressUserViewDTO(address.getAddress(), address.getStreet(), address.getNeighborhood(), 
									address.getDistrict(),address.getCity());
		
	}
	
	
	

}
