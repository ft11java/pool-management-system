package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Role;


import lombok.Getter;
@Getter
public class RoleUserViewDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String role;

	public RoleUserViewDTO(String role) {
		
		this.role = role;
	}
	
	public static RoleUserViewDTO of(Role role) {
		
		return new RoleUserViewDTO(role.getRole()); 
	}
	
	

}
