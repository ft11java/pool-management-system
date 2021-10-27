package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.havuzentity.havuzentitty.dto.RoleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.RoleCreateDTO;
import com.havuzentity.havuzentitty.dto.RoleUpdateDTO;
import com.havuzentity.havuzentitty.dto.RoleUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;

import com.havuzentity.havuzentitty.model.Role;
import com.havuzentity.havuzentitty.repository.RoleRepository;
import com.havuzentity.havuzentitty.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
	
	private final RoleRepository roleRepository;

	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public RoleAdminViewDTO getRoleAdminById(int id) {
		final Role role=roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return RoleAdminViewDTO.of(role);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public RoleUserViewDTO getRoleUserById(int id) {
		final Role role=roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
				
		return RoleUserViewDTO.of(role);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<RoleAdminViewDTO> getAllRole() {
		
		return roleRepository.findAll().stream().map(RoleAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public RoleAdminViewDTO createRole(@Valid RoleCreateDTO roleCreateDTO) {
		final Role role=roleRepository.save(new Role(roleCreateDTO.getRole()));
		
		return RoleAdminViewDTO.of(role);
	}

	@Override
	@Transactional
	public RoleAdminViewDTO updateRole(int id, RoleUpdateDTO roleUpdateDTO) {
		final Role role=roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		role.setRole(roleUpdateDTO.getRole());
		final Role updateRole=roleRepository.save(role);

		return RoleAdminViewDTO.of(updateRole);
	}

	@Override
	@Transactional
	public void deleteRole(int id) {
		final Role role=roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		roleRepository.deleteById(role.getId());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<RoleAdminViewDTO> roleSlice(Pageable pageable) {
		
		return roleRepository.findAll(pageable).stream().map(RoleAdminViewDTO::of).collect(Collectors.toList());
	}
	

	

}
