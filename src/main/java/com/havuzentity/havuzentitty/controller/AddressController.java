package com.havuzentity.havuzentitty.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havuzentity.havuzentitty.dto.AddressCreateDTO;
import com.havuzentity.havuzentitty.dto.AddressUserViewDTO;
import com.havuzentity.havuzentitty.dto.AddressAdminViewDTO;
import com.havuzentity.havuzentitty.dto.AdsressUpdateDTO;
import com.havuzentity.havuzentitty.service.AddressService;
import com.havuzentity.havuzentitty.shared.GenericResponse;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AddressController {

	private final AddressService addressService;

	@GetMapping("v1/admin/address/{id}")
	public ResponseEntity<AddressAdminViewDTO> getAddressById(@PathVariable("id") int id) {
		final AddressAdminViewDTO address = addressService.getAddressById(id);
		return ResponseEntity.ok(address);
	}

	@GetMapping("v1/user/address/{id}")
	public ResponseEntity<AddressUserViewDTO> getUserAddressById(@PathVariable("id") int id) {
		final AddressUserViewDTO address = addressService.getUserAddressById(id);
		return ResponseEntity.ok(address);
	}

	@GetMapping("v1/admin/address")
	public ResponseEntity<List<AddressAdminViewDTO>> getAddresses() {
		final List<AddressAdminViewDTO> addresses = addressService.getAddresses();
		return ResponseEntity.ok(addresses);
	}

	@PostMapping("v1/admin/address")
	public ResponseEntity<?> createAddress(@Valid @RequestBody AddressCreateDTO addressCreateDTO) {
		addressService.createAddress(addressCreateDTO);
		return ResponseEntity.ok(new GenericResponse("Adsress Created..."));

	}

	@PutMapping("v1/admin/address/{id}")
	public ResponseEntity<AddressAdminViewDTO> updateAddress(@PathVariable("id") int id,
			@RequestBody AdsressUpdateDTO addressUpdateDTO) {
		final AddressAdminViewDTO address = addressService.updateAddress(id, addressUpdateDTO);

		return ResponseEntity.ok(address);
	}

	@DeleteMapping("v1/admin/address/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable("id") int id) {
		addressService.deleteAddress(id);

		return ResponseEntity.ok(new GenericResponse("Address Deleted"));
	}

	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/address/slice")
	public ResponseEntity<List<AddressAdminViewDTO>> addressSlice(Pageable pageable) {
		final List<AddressAdminViewDTO> address = addressService.addressSlice(pageable);

		return ResponseEntity.ok(address);
	}

}