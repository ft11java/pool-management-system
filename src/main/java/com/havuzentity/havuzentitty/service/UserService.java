package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.UserAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserCreateDTO;
import com.havuzentity.havuzentitty.dto.UserUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserUserViewDTO;

public interface UserService {

	UserAdminViewDTO getUserById(int id);

	UserUserViewDTO getUserUserById(int id);

	List<UserAdminViewDTO> getAllUser();

	UserAdminViewDTO createUser(@Valid UserCreateDTO userCerateDTO);

	UserAdminViewDTO updateUser(int id, UserUpdateDTO userUpdateDTO);

	void deleteUser(int id);

	List<UserAdminViewDTO> userSlice(Pageable pageable);

	UserUserViewDTO getUserUserById(String userName);
	

}
