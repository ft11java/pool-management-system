package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.User;


import lombok.Getter;

@Getter
public class UserInPoolViewUserDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String name;
	private String lastName;
	private String phoneNumber;
	private UserTitleUserViewDTO userTitles;
	
	
	public UserInPoolViewUserDTO(String name, String lastName, String phoneNumber, UserTitleUserViewDTO userTitles) {
	
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userTitles = userTitles;
	}
	
 public static UserInPoolViewUserDTO of(User user) {
		 
		 return new UserInPoolViewUserDTO(
				
				 user.getName(),
				 user.getLastName(),
				 user.getPhoneNumber(),
				 UserTitleUserViewDTO.of(user.getUserTitles()));
	 }
	
	
	

}
