package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
public class UserUpdateDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String userName;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String email;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String password;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String name;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String lastName;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String phoneNumber;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int userTitlesId;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private boolean isAccountNonExpired;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private boolean isAccountNonLocked;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private boolean isCredentialsNonExpired;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private boolean isEnabled;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int roleId;
}
