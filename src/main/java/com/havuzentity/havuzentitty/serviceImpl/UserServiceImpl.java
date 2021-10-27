package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.havuzentity.havuzentitty.dto.UserAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserCreateDTO;
import com.havuzentity.havuzentitty.dto.UserUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.Role;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.model.UserTitle;
import com.havuzentity.havuzentitty.repository.RoleRepository;
import com.havuzentity.havuzentitty.repository.UserRepository;
import com.havuzentity.havuzentitty.repository.UserTitleRepository;
import com.havuzentity.havuzentitty.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	 
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserTitleRepository userTitleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserAdminViewDTO getUserById(int id) {
		final User user=userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return UserAdminViewDTO.of(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserUserViewDTO getUserUserById(int id) {
		final User user=userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return UserUserViewDTO.of(user);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserUserViewDTO getUserUserById(String userName) {
		final User user=userRepository.findByUserName(userName)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
			
		
		return UserUserViewDTO.of(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserAdminViewDTO> getAllUser() {
		
		return userRepository.findAll().stream().map(UserAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserAdminViewDTO createUser(@Valid UserCreateDTO userCerateDTO) {
		final UserTitle userTitle=userTitleRepository.findById(userCerateDTO.getUserTitlesId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final Role role=roleRepository.findById(userCerateDTO.getRoleId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		String pwd = userCerateDTO.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		final User user=userRepository.save(new User(
				userCerateDTO.getUserName(),
				userCerateDTO.getEmail(),
				encryptPwd,
				userCerateDTO.getName(),
				userCerateDTO.getLastName(),
				userCerateDTO.getPhoneNumber(),
				userTitle,
				userCerateDTO.isAccountNonExpired(),
				userCerateDTO.isAccountNonLocked(),
				userCerateDTO.isCredentialsNonExpired(),
				userCerateDTO.isEnabled(),
				role));
		
		return UserAdminViewDTO.of(user);
	}

	@Override
	@Transactional
	public UserAdminViewDTO updateUser(int id, UserUpdateDTO userUpdateDTO) {
		final User user=userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final UserTitle userTitle=userTitleRepository.findById(userUpdateDTO.getUserTitlesId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final Role role=roleRepository.findById(userUpdateDTO.getRoleId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		user.setUserName(userUpdateDTO.getUserName());
		user.setEmail(userUpdateDTO.getEmail());
		String pwd = userUpdateDTO.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		user.setLastName(userUpdateDTO.getName());
		user.setName(userUpdateDTO.getLastName());
		user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
		user.setUserTitles(userTitle);
		user.setAccountNonExpired(userUpdateDTO.isAccountNonExpired());
		user.setAccountNonLocked(userUpdateDTO.isAccountNonLocked());
		user.setCredentialsNonExpired(userUpdateDTO.isCredentialsNonExpired());
		user.setEnabled(userUpdateDTO.isEnabled());
		user.setRoles(role);
		
		final User userUpdate=userRepository.save(user);
		
		return UserAdminViewDTO.of(userUpdate);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		final User user=userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		userRepository.deleteById(user.getId());
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserAdminViewDTO> userSlice(Pageable pageable) {
	
		return userRepository.findAll(pageable).stream().map(UserAdminViewDTO::of).collect(Collectors.toList());
	}

	
	
}
