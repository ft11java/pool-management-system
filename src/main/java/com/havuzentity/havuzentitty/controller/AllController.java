package com.havuzentity.havuzentitty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AllController {
	
	@GetMapping("v1/all")
	public String mesage() {
		String message="Hello All";
		return message;
	}

}
