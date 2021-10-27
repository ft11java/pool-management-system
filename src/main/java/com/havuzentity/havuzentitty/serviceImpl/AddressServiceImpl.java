package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havuzentity.havuzentitty.dto.AddressCreateDTO;
import com.havuzentity.havuzentitty.dto.AddressUserViewDTO;
import com.havuzentity.havuzentitty.dto.AddressAdminViewDTO;
import com.havuzentity.havuzentitty.dto.AdsressUpdateDTO;
import com.havuzentity.havuzentitty.repository.AddressRepository;
import com.havuzentity.havuzentitty.service.AddressService;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.Address;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public AddressAdminViewDTO getAddressById(int id) {

		final Address address = addressRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return AddressAdminViewDTO.of(address);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<AddressAdminViewDTO> getAddresses() {
		
		return addressRepository.findAll().stream().map(AddressAdminViewDTO::of).collect(Collectors.toList());
	}
	
	
	
	@Override
	@Transactional
	public AddressAdminViewDTO createAddress(AddressCreateDTO addressCreateDTO) {
		final Address address = addressRepository.save(new Address(addressCreateDTO.getAddress(),
				addressCreateDTO.getStreet(), addressCreateDTO.getNeighborhood(), addressCreateDTO.getDistrict(),
				addressCreateDTO.getCity()));

		return AddressAdminViewDTO.of(address);
	}

	@Override
	@Transactional
	public AddressAdminViewDTO updateAddress(int id, AdsressUpdateDTO addressUpdateDTO) {
			final Address address = addressRepository.findById(id)
					.orElseThrow(()->new NotFoundException("Not Found Exception"));
			address.setAddress(addressUpdateDTO.getAddress());
			address.setStreet(addressUpdateDTO.getStreet());
			address.setNeighborhood(addressUpdateDTO.getNeighborhood());
			address.setDistrict(addressUpdateDTO.getDistrict());
			address.setCity(addressUpdateDTO.getCity());
			
			final Address updateAddress= addressRepository.save(address);
		return AddressAdminViewDTO.of(updateAddress);
	}

	@Override
	@Transactional
	public void deleteAddress(int id) {
		final Address address=addressRepository.findById(id)
				.orElseThrow(()->new NotFoundException("Not Fount Exception"));
		addressRepository.deleteById(address.getId());
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<AddressAdminViewDTO> addressSlice(Pageable pageable) {
		
		return addressRepository.findAll(pageable).stream().map(AddressAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public AddressUserViewDTO getUserAddressById(int id) {
		final Address address = addressRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return AddressUserViewDTO.of(address);
	}

	

	

}
