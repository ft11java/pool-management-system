package com.havuzentity.havuzentitty.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havuzentity.havuzentitty.dto.LoginControlDTO;
import com.havuzentity.havuzentitty.model.UserLogin;
import com.havuzentity.havuzentitty.service.LoginControlService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginControlService loginControlService;
	
	@GetMapping("v1/validateLogin")
	public UserLogin validateLogin() {
		return new UserLogin("User successfully authenticated");
	}
	
	@GetMapping("v1/validateLoginRole/{userName}")
	public ResponseEntity<LoginControlDTO>  validateLoginRole(@PathVariable String userName){
		final LoginControlDTO loginControlDTO=loginControlService.getUserByUserNamee(userName);
		
		return ResponseEntity.ok(loginControlDTO);
		
	}
	

}
