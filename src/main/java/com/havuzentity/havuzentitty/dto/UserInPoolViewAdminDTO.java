package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.model.UserTitle;

import lombok.Getter;

@Getter
public class UserInPoolViewAdminDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String lastName;
	private String phoneNumber;
	private UserTitle userTitles;
	
	public UserInPoolViewAdminDTO(int id, String name, String lastName, String phoneNumber, UserTitle userTitles) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userTitles = userTitles;
	}	
	
	 public static UserInPoolViewAdminDTO of(User user) {
		 
		 return new UserInPoolViewAdminDTO(
				 user.getId(),
				 user.getName(),
				 user.getLastName(),
				 user.getPhoneNumber(),
				 user.getUserTitles());
	 }
	 
	
	
	
}
