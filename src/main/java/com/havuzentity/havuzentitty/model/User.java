package com.havuzentity.havuzentitty.model;



import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


//@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	
	@Column(name = "user_name" ,unique = true)
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne(/*cascade = CascadeType.ALL,*/fetch = FetchType.EAGER)
	@JoinColumn(name="user_title_id")
	private UserTitle userTitles;
	
	@Column(name = "is_account_non_expire")
	private boolean isAccountNonExpired;
	
	@Column(name="is_accountn_on_locked")
	private boolean isAccountNonLocked;
	
	@Column(name="is_credentials_non_expired")
	private boolean isCredentialsNonExpired;
	
	@Column(name="is_enabled")
	private boolean isEnabled;
	

	@ManyToOne(/*cascade = CascadeType.ALL,*/fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role roles;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "users")
	private Set<Pool> pools = new HashSet<>();

	
	public User(String userName, String email, String password, String name, String lastName, String phoneNumber,
			UserTitle userTitles, boolean isAccountNonExpired, boolean isAccountNonLocked,
			boolean isCredentialsNonExpired, boolean isEnabled, Role roles) {
		
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userTitles = userTitles;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

}