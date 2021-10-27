package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.UserTitle;

import lombok.Getter;

@Getter
public class UserTitleAdminViewDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userTitleName;
	
	public UserTitleAdminViewDTO(int id, String userTitleName) {
	
		this.id = id;
		this.userTitleName = userTitleName;
	}
	
	public static UserTitleAdminViewDTO of(UserTitle userTitle) {
		
		return new UserTitleAdminViewDTO(userTitle.getId(), userTitle.getUserTitleName());
	}
	
	
}
