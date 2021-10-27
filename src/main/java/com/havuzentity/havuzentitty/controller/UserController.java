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
import com.havuzentity.havuzentitty.dto.UserAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserCreateDTO;
import com.havuzentity.havuzentitty.dto.UserUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserUserViewDTO;
import com.havuzentity.havuzentitty.service.UserService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;


	@GetMapping("v1/admin/user/{id}")
	public ResponseEntity<UserAdminViewDTO> getUserAdminById(@PathVariable("id")int id){
		final UserAdminViewDTO user=userService.getUserById(id);
		
		return ResponseEntity.ok(user);		
		
	}
	
	@GetMapping("v1/user/user/{id}")
	public ResponseEntity<UserUserViewDTO> getUserUserById(@PathVariable("id")int id){
		final UserUserViewDTO user=userService.getUserUserById(id);
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("v1/user/username/{userName}")
	public ResponseEntity<UserUserViewDTO> getUserUserById(@PathVariable("userName")String userName){
		final UserUserViewDTO user=userService.getUserUserById(userName);
		
		return ResponseEntity.ok(user);
	}
	

	
	@GetMapping("v1/admin/user")
	public ResponseEntity<List<UserAdminViewDTO>> getAllUser(){
		final List<UserAdminViewDTO> user=userService.getAllUser();
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("v1/admin/user")
	public ResponseEntity<?>  createUser (@Valid @RequestBody UserCreateDTO userCerateDTO){
		userService.createUser(userCerateDTO);
		
		
		return ResponseEntity.ok(new GenericResponse("User Created..."));
		
	}
	
	@PutMapping("v1/admin/user/{id}")
	public ResponseEntity<UserAdminViewDTO> updateUserTitle(@PathVariable("id")int id,
			@RequestBody UserUpdateDTO userUpdateDTO){
	final UserAdminViewDTO userTitle=userService.updateUser(id,userUpdateDTO);
	
	return ResponseEntity.ok(userTitle);
		
	}	
	
	@DeleteMapping("v1/admin/user/{id}")
	ResponseEntity<?> deleteUser (@PathVariable("id")int id){
		userService.deleteUser(id);
		
		return ResponseEntity.ok(new GenericResponse("User Deleted"));
	}
	
	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/user/slice")
	ResponseEntity<List<UserAdminViewDTO>> userSlice(Pageable pageable){
		final List<UserAdminViewDTO> user=userService.userSlice(pageable);
		
		return ResponseEntity.ok(user);
	}

}
