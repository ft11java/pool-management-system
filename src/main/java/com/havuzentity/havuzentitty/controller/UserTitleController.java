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


import com.havuzentity.havuzentitty.dto.UserTitleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserTitleCreateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUserViewDTO;

import com.havuzentity.havuzentitty.service.UserTitleService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserTitleController {
	
	private final UserTitleService userTitleService;
	
	
	@GetMapping("v1/admin/user-title/{id}")
	public ResponseEntity<UserTitleAdminViewDTO> getUserTitleAdminById(@PathVariable("id")int id){
		final UserTitleAdminViewDTO userTitle=userTitleService.getUserTitleAdminById(id);
		
		return ResponseEntity.ok(userTitle);
		
	}
	
	@GetMapping("v1/user/user-title/{id}")
	public ResponseEntity<UserTitleUserViewDTO> getUserTtleUserById(@PathVariable("id")int id){
		final UserTitleUserViewDTO userTitle=userTitleService.getUserTitleUserById(id);
		
		return ResponseEntity.ok(userTitle);
	}	
	
	@GetMapping("v1/admin/user-title")
	public ResponseEntity<List<UserTitleAdminViewDTO>> getAllUserTitle(){
		final List<UserTitleAdminViewDTO> userTitle=userTitleService.getAllUserTitle();
		
		return ResponseEntity.ok(userTitle);
	}
	
	@PostMapping("v1/admin/user-title")
	public ResponseEntity<?> createUserTitle(@Valid @RequestBody UserTitleCreateDTO userTitleCreateDTO){
		userTitleService.createUserTitle(userTitleCreateDTO);
		
		return ResponseEntity.ok(new GenericResponse("User Title Created..."));
	}
	
	@PutMapping("v1/admin/user-title/{id}")
	public ResponseEntity<UserTitleAdminViewDTO> updateUserTitle (@PathVariable("id")int id,
			@RequestBody UserTitleUpdateDTO userTitleUpdateDTO){
		final UserTitleAdminViewDTO userTitle=userTitleService.updateUserTitle(id,userTitleUpdateDTO);
		
		return ResponseEntity.ok(userTitle);
	}
	
	@DeleteMapping("v1/admin/user-title/{id}")
	public ResponseEntity<?> deleteUserTitle(@PathVariable("id")int id){
		userTitleService.deleteUserTitle(id);
		
		return ResponseEntity.ok(new GenericResponse("User Title Deleted"));
	}
	
	
	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/user-title/slice")
	public ResponseEntity<List<UserTitleAdminViewDTO>> userTitleSlice(Pageable pageable){
		final List<UserTitleAdminViewDTO> userTitle=userTitleService.userTitleSlice(pageable);
		
		return ResponseEntity.ok(userTitle);
	}

}
