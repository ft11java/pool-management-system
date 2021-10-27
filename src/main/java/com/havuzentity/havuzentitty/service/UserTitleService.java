package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.UserTitleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserTitleCreateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUserViewDTO;

public interface UserTitleService {

	UserTitleAdminViewDTO getUserTitleAdminById(int id);

	UserTitleUserViewDTO getUserTitleUserById(int id);

	List<UserTitleAdminViewDTO> getAllUserTitle();

	UserTitleAdminViewDTO createUserTitle(@Valid UserTitleCreateDTO userTitleCreateDTO);

	UserTitleAdminViewDTO updateUserTitle(int id, UserTitleUpdateDTO userTitleUpdateDTO);

	void deleteUserTitle(int id);

	List<UserTitleAdminViewDTO> userTitleSlice(Pageable pageable);

}
