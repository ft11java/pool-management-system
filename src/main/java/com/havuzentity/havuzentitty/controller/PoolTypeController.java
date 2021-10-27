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
import com.havuzentity.havuzentitty.dto.PoolTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUserViewDTO;
import com.havuzentity.havuzentitty.service.PoolTypeService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PoolTypeController {

	private final PoolTypeService poolTypeService;

	@GetMapping("v1/admin/pool-type/{id}")
	public ResponseEntity<PoolTypeAdminViewDTO> getPoolTypeAdminById(@PathVariable("id") int id) {
		final PoolTypeAdminViewDTO poolType = poolTypeService.getPoolTypeAdminById(id);

		return ResponseEntity.ok(poolType);
	}

	@GetMapping("v1/user/pool-type/{id}")
	public ResponseEntity<PoolTypeUserViewDTO> getPoolTypeUserById(@PathVariable("id") int id) {
		final PoolTypeUserViewDTO poolType = poolTypeService.getPoolTypeUserById(id);

		return ResponseEntity.ok(poolType);
	}

	@GetMapping("v1/admin/pool-type")
	public ResponseEntity<List<PoolTypeAdminViewDTO>> getAllPoolType() {
		final List<PoolTypeAdminViewDTO> poolType = poolTypeService.getAllPoolType();

		return ResponseEntity.ok(poolType);
	}

	@PostMapping("v1/admin/pool-type")
	public ResponseEntity<?> createPoolType(@Valid @RequestBody PoolTypeCreateDTO poolTypeCreateDTO) {
		poolTypeService.createPoolType(poolTypeCreateDTO);

		return ResponseEntity.ok(new GenericResponse("Pool Type Created..."));

	}

	@PutMapping("v1/admin/pool-type/{id}")
	public ResponseEntity<PoolTypeAdminViewDTO> updatePoolType(@PathVariable("id") int id,
			@RequestBody PoolTypeUpdateDTO poolTypeUpdateDTO) {
		final PoolTypeAdminViewDTO poolType = poolTypeService.updatePoolType(id, poolTypeUpdateDTO);

		return ResponseEntity.ok(poolType);

	}

	@DeleteMapping("v1/admin/pool-type/{id}")
	public ResponseEntity<?> deletePoolType(@PathVariable("id") int id) {
		poolTypeService.deletePoolType(id);

		return ResponseEntity.ok(new GenericResponse("Pool Type Deleted"));

	}

	// slice?page=3&size=7 ----uarl slice den sonra geleck kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/pool-type/slice")
	public ResponseEntity<List<PoolTypeAdminViewDTO>> poolTypeSlice(Pageable pageable) {
		final List<PoolTypeAdminViewDTO> poolType = poolTypeService.poolTypeSlice(pageable);

		return ResponseEntity.ok(poolType);
	}

}
