package com.havuzentity.havuzentitty.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.AddressCreateDTO;
import com.havuzentity.havuzentitty.dto.AddressUserViewDTO;
import com.havuzentity.havuzentitty.dto.AddressAdminViewDTO;
import com.havuzentity.havuzentitty.dto.AdsressUpdateDTO;




public interface AddressService {
	
	AddressAdminViewDTO getAddressById (int id) ;

	AddressAdminViewDTO createAddress(AddressCreateDTO addressCreateDTO);

	List<AddressAdminViewDTO> getAddresses();

	AddressAdminViewDTO updateAddress(int id, AdsressUpdateDTO addressUpdateDTO);

	void deleteAddress(int id);

	List<AddressAdminViewDTO> addressSlice(Pageable pageable);

	AddressUserViewDTO getUserAddressById(int id);



}
