package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.Role;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.model.UserTitle;

import lombok.Getter;

@Getter
public class UserAdminViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private int id;
	private String userName;
	private String email;
	private String password;
	private String name;
	private String lastName;
	private String phoneNumber;
	private UserTitle userTitles;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Role roles;
	private List<PoolInUserViewAdminDTO> poolInUserViewAdminDTO;
	
	
	public UserAdminViewDTO(int id, String userName, String email, String password, String name, String lastName,
			String phoneNumber, UserTitle userTitles, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, Role roles,
			List<PoolInUserViewAdminDTO> poolInUserViewAdminDTO) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userTitles = userTitles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.roles = roles;
		this.poolInUserViewAdminDTO = poolInUserViewAdminDTO;
	}
	
	
public static UserAdminViewDTO of(User user) {
		
		return new UserAdminViewDTO(
				user.getId(),
				user.getUserName(),
				user.getEmail(),
				user.getPassword(),
				user.getName(),
				user.getLastName(),
				user.getPhoneNumber(),
				user.getUserTitles(),
				user.isAccountNonExpired(),
				user.isAccountNonLocked(),
				user.isCredentialsNonExpired(),
				user.isEnabled(),
				user.getRoles(),
				user.getPools().stream().map(PoolInUserViewAdminDTO::of).collect(Collectors.toList()));
	}






	

	
}
