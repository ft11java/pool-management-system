package com.havuzentity.havuzentitty.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		
		if(user==null) {
			throw new UsernameNotFoundException("User not exist with name  :"+ userName);
		}
		return new UserDetailsImpl(user);
	}
	

}
