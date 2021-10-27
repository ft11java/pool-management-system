package com.havuzentity.havuzentitty.serviceImpl;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.havuzentity.havuzentitty.model.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	private List<GrantedAuthority>authorities;
	
	
	
	public UserDetailsImpl() {}
	
	public UserDetailsImpl(User user) {
	
		this.userName = user.getUserName();
		this.password = user.getPassword();
		
		this.isAccountNonExpired = user.isAccountNonExpired();
		this.isAccountNonLocked = user.isAccountNonLocked();
		this.isCredentialsNonExpired = user.isCredentialsNonExpired();
		this.isEnabled = user.isEnabled();                 
		this.authorities=Arrays.stream(user.getRoles().getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}


	

	@Override
	public String getPassword() {
	
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	public String getUserName() {
		return userName;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		
		return isEnabled;
	}

	
}
