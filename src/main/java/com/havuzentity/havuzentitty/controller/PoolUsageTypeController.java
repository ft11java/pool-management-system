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

import com.havuzentity.havuzentitty.dto.PoolUsageTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUpdate;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUserViewDTO;
import com.havuzentity.havuzentitty.service.PoolUsageTypeService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PoolUsageTypeController {
	
	private final PoolUsageTypeService poolUsageTypeService;
	

	@GetMapping("v1/admin/pool-usage-type/{id}")
	public ResponseEntity<PoolUsageTypeAdminViewDTO> getPoolUsageTypeAdminById(@PathVariable("id") int id){
		final PoolUsageTypeAdminViewDTO poolUsageType=poolUsageTypeService.getPoolUsageTypeAdminById(id);
		
		return ResponseEntity.ok(poolUsageType);
	}
	
	@GetMapping("v1/user/pool-usage-type/{id}")
	public ResponseEntity<PoolUsageTypeUserViewDTO> getPoolUsageTypeUserById(@PathVariable("id")int id){
		final PoolUsageTypeUserViewDTO poolUsageType=poolUsageTypeService.poolUsageTypeUserById(id);
		
		return ResponseEntity.ok(poolUsageType);
	}
	
	@GetMapping("v1/admin/pool-usage-type")
	public ResponseEntity<List<PoolUsageTypeAdminViewDTO>> getAllPoolUsageType() {
		final List<PoolUsageTypeAdminViewDTO> poolUsageType=poolUsageTypeService.getAllPoolUsageType();
			
			return ResponseEntity.ok(poolUsageType);
	}
	
	@PostMapping("v1/admin/pool-usage-type")
	public ResponseEntity<?> createPoolUsageType (@Valid @RequestBody PoolUsageTypeCreateDTO poolUsageTypeCreateViewDTO){
		poolUsageTypeService.createPoolUsageType(poolUsageTypeCreateViewDTO);
		
		return ResponseEntity.ok(new GenericResponse("Pool Usage Type Created..."));
		
	}
	
	@PutMapping("v1/admin/pool-usage-type/{id}")
	public ResponseEntity<PoolUsageTypeAdminViewDTO> updatePoolUsageType(@PathVariable("id")int id,
			@RequestBody PoolUsageTypeUpdate poolUsageTypeUpdate){
		final PoolUsageTypeAdminViewDTO poolUsageType=poolUsageTypeService.updatePoolUsageType(id,poolUsageTypeUpdate);
		
		return ResponseEntity.ok(poolUsageType);
	}
	
	@DeleteMapping("v1/admin/pool-usage-type/{id}")
	public ResponseEntity<?> deletePoolUsageType(@PathVariable("id")int id){
		poolUsageTypeService.deletePoolUsageType(id);
		
		return ResponseEntity.ok(new GenericResponse("Pool Usage Type Deleted"));
	}
	
	
	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
		// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/pool-usage-type/slice")
	public ResponseEntity<List<PoolUsageTypeAdminViewDTO>> poolUsageTypeSlice(Pageable pageable){
		final List<PoolUsageTypeAdminViewDTO> poolUsageType=poolUsageTypeService.poolUsageTypeSlice(pageable);
		
		return ResponseEntity.ok(poolUsageType);
		
	}
	

}
