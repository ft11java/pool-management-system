package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.UserTitle;

import lombok.Getter;

@Getter
public class UserTitleUserViewDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	
	private String userTitleName;
	
	public UserTitleUserViewDTO(String userTitleName) {
	
		this.userTitleName = userTitleName;
	}
	
	public static UserTitleUserViewDTO of(UserTitle userTitle) {
		
		return new UserTitleUserViewDTO( userTitle.getUserTitleName());
	}
	
	
}