package com.havuzentity.havuzentitty.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.havuzentity.havuzentitty.dto.RoleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.RoleCreateDTO;
import com.havuzentity.havuzentitty.dto.RoleUpdateDTO;
import com.havuzentity.havuzentitty.dto.RoleUserViewDTO;
import com.havuzentity.havuzentitty.service.RoleService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {
	
	private final RoleService roleService;
	

	
	@GetMapping("v1/admin/role/{id}")
	public ResponseEntity<RoleAdminViewDTO> getRoelAdminById(@PathVariable("id")int id){
		final RoleAdminViewDTO role=roleService.getRoleAdminById(id);
		
		return ResponseEntity.ok(role);
	}
	
	@GetMapping("v1/user/role/{id}")
	public ResponseEntity<RoleUserViewDTO> getRoleUserById(@PathVariable("id")int id){
		final RoleUserViewDTO role=roleService.getRoleUserById(id);
		
		return ResponseEntity.ok(role);
	}
	
	@GetMapping("v1/admin/role")
	public ResponseEntity<List<RoleAdminViewDTO>> getAllRole(){
		final List<RoleAdminViewDTO> role=roleService.getAllRole();
		
		return ResponseEntity.ok(role);
	}
	
	@PostMapping("v1/admin/role")
	public ResponseEntity<?> createRole (@Valid @RequestBody RoleCreateDTO roleCreateDTO){
		roleService.createRole(roleCreateDTO);
		
		return ResponseEntity.ok(new GenericResponse("Role Created..."));
	}
	
	@PutMapping("v1/admin/role/{id}")
	public ResponseEntity<RoleAdminViewDTO> updateRole (@PathVariable("id")int id,@RequestBody RoleUpdateDTO roleUpdateDTO){
		final RoleAdminViewDTO role=roleService.updateRole(id,roleUpdateDTO);
		
		return ResponseEntity.ok(role);
	}
	
	@DeleteMapping("v1/admin/role/{id}")
	public ResponseEntity<?> deleteRole (@PathVariable("id")int id){
		roleService.deleteRole(id);
		
		return ResponseEntity.ok(new GenericResponse("Role Deleted..."));
	}
	
	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/role/slice")
		public ResponseEntity<List<RoleAdminViewDTO>> roleSlice(Pageable pageable){
		final List<RoleAdminViewDTO> role=roleService.roleSlice(pageable);
		
		return ResponseEntity.ok(role);
	}
	
}
