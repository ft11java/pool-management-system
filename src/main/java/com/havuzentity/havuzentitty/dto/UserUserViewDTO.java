package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.User;


import lombok.Getter;

@Getter
public class UserUserViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String userName;
	private String email;
	private String name;
	private String lastName;
	private String phoneNumber;
	private UserTitleUserViewDTO userTitles;
	private RoleUserViewDTO roles;
	private List<PoolInUserViewUserDTO> poolInUserViewUserDTO;

	public UserUserViewDTO(String userName, String email,String name, String lastName, String phoneNumber,
			UserTitleUserViewDTO userTitles, RoleUserViewDTO roles, List<PoolInUserViewUserDTO> poolInUserViewUserDTO) {
		
		this.userName = userName;
		this.email = email;
		this.name=name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userTitles = userTitles;
		this.roles = roles;
		this.poolInUserViewUserDTO = poolInUserViewUserDTO;
	}
	
	public static UserUserViewDTO of(User user) {
		
		return new UserUserViewDTO(
				user.getUserName(),
				user.getEmail(),
				user.getName(),
				user.getLastName(),
				user.getPhoneNumber(),
				UserTitleUserViewDTO.of(user.getUserTitles()),
				RoleUserViewDTO.of(user.getRoles()),
				user.getPools().stream().map(PoolInUserViewUserDTO::of).collect(Collectors.toList())
				);
				
	}
	
}


