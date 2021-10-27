package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Address;

import lombok.Getter;

@Getter
public final class AddressAdminViewDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private final int id;
	
	private final String address;
	
	private final String street;

	private final String neighborhood;
	
	private final String district;
	
	private final String city;

	
	public AddressAdminViewDTO(int id,String address, String street, String neighborhood, String district, String city) {
	
		this.id=id;
		this.address = address;
		this.street = street;
		this.neighborhood = neighborhood;
		this.district = district;
		this.city = city;
	}
	
	public static AddressAdminViewDTO of(Address address) {
		
		return new AddressAdminViewDTO(address.getId(),address.getAddress(), address.getStreet(), address.getNeighborhood(), 
									address.getDistrict(),address.getCity());
		
	}
	
	
	

}
