package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import com.havuzentity.havuzentitty.model.User;
import lombok.Getter;

@Getter
public class LoginControlDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	private String userName;
	 
	private RoleUserViewDTO role;

	public LoginControlDTO(String userName, RoleUserViewDTO role) {

		this.userName = userName;
		this.role = role;
		
	}
	
	public static LoginControlDTO of(User user) {
		
		return new LoginControlDTO(
				user.getUserName(),
				RoleUserViewDTO.of(user.getRoles()));
	}
}
