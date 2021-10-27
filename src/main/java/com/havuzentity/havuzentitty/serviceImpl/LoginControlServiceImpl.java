package com.havuzentity.havuzentitty.serviceImpl;


import org.springframework.stereotype.Service;

import com.havuzentity.havuzentitty.dto.LoginControlDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.repository.UserRepository;
import com.havuzentity.havuzentitty.service.LoginControlService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginControlServiceImpl implements LoginControlService {
	
	private final UserRepository userRepository;

	@Override
	public LoginControlDTO getUserByUserNamee(String userName) {
		final User user=userRepository.findByUserName(userName)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return LoginControlDTO.of(user);
	}
	

}
