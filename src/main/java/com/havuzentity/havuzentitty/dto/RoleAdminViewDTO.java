package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Role;


import lombok.Getter;

@Getter
public class RoleAdminViewDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	  private int id;
	  private String role;
	
	  public RoleAdminViewDTO(int id, String role) {

		this.id = id;
		this.role = role;
	}
	  
	  public static RoleAdminViewDTO of(Role role) {
		  
		  return new RoleAdminViewDTO(role.getId(), role.getRole());
	  }
	  

}
