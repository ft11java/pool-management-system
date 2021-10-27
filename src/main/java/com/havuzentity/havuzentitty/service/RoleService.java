package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.RoleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.RoleCreateDTO;
import com.havuzentity.havuzentitty.dto.RoleUpdateDTO;
import com.havuzentity.havuzentitty.dto.RoleUserViewDTO;

public interface RoleService {

	RoleAdminViewDTO getRoleAdminById(int id);

	RoleUserViewDTO getRoleUserById(int id);

	List<RoleAdminViewDTO> getAllRole();

	RoleAdminViewDTO createRole(@Valid RoleCreateDTO roleCreateDTO);

	RoleAdminViewDTO updateRole(int id, RoleUpdateDTO roleUpdateDTO);

	void deleteRole(int id);

	List<RoleAdminViewDTO> roleSlice(Pageable pageable);

}
