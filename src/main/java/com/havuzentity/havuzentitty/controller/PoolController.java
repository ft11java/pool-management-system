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

import com.havuzentity.havuzentitty.dto.PoolAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolViewAllDTO;
import com.havuzentity.havuzentitty.dto.PoolViewUserDTO;
import com.havuzentity.havuzentitty.service.PoolService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200",exposedHeaders ="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PoolController {
	
	private final PoolService poolService;
	
	
	
	@GetMapping("v1/admin/pool/{id}")
	public ResponseEntity<PoolAdminViewDTO> getPoolById(@PathVariable("id")int id){
		final PoolAdminViewDTO pool=poolService.getPoolById(id);
		
		return ResponseEntity.ok(pool);
	}
	
	@GetMapping("v1/user/pool/{id}")
	public ResponseEntity<PoolViewUserDTO>  getUserPoolById(@PathVariable("id")int id){
		final PoolViewUserDTO pool=poolService.getUserPoolById(id);
		
		return ResponseEntity.ok(pool);
	}
	
	@GetMapping("v1/user/pools/{username}")
	public ResponseEntity<List<PoolViewUserDTO>>  getUserPoolById(@PathVariable("username")String userName){
		final List<PoolViewUserDTO> pool=poolService.getUserPoolByUserName(userName);
		
		return ResponseEntity.ok(pool);
	}
	
	@GetMapping("v1/user/pools/poolnumber/{poolNumber}")
	public ResponseEntity<PoolViewUserDTO> getUserPoolByPoolNumber(@PathVariable("poolNumber")String poolNumber){
		final PoolViewUserDTO pool=poolService.getUserPoolByPoolNumber(poolNumber);
		
		return ResponseEntity.ok(pool);
	}
	
	@GetMapping("v1/admin/pool")
	public ResponseEntity<List<PoolAdminViewDTO>> getAllPool(){
		final List<PoolAdminViewDTO> pool=poolService.getAllPool();
		
		return ResponseEntity.ok(pool);
	}
	

	@GetMapping("/v1/viewall/pool/{poolNumber}")
	public ResponseEntity<PoolViewAllDTO> getPoolViewAllVisitor(@PathVariable("poolNumber") String poolNumber){
		PoolViewAllDTO pool=poolService.getPoolViewAllVisitor(poolNumber);
		
		return ResponseEntity.ok(pool);
	}
	
	@PostMapping("v1/admin/pool")
	public ResponseEntity<?> createPool(@Valid @RequestBody PoolCreateDTO poolCreateDTO){
		poolService.createPool(poolCreateDTO);
		
		return ResponseEntity.ok(new GenericResponse("Pool Created..."));
	} 
	
	@PutMapping("v1/admin/pool/{id}")
	public  ResponseEntity<PoolAdminViewDTO> updatePool(@PathVariable("id")int id,
			@RequestBody PoolUpdateDTO poolUpdateDTO){
		final PoolAdminViewDTO pool=poolService.updatePool(id,poolUpdateDTO);
		
		return ResponseEntity.ok(pool);
	}
	
	@DeleteMapping("v1/admin/pool/{id}")
	public ResponseEntity<?> deletePool(@PathVariable("id")int id){
		poolService.deletePool(id);
		
		return ResponseEntity.ok(new GenericResponse("Pool Deleted"));
		
	}

	@GetMapping("v1/admin/pool/{poolId}//adduser/{userId}")
	public ResponseEntity<PoolAdminViewDTO> addPoolToUser(@PathVariable("poolId")int poolId,@PathVariable("userId")int userId){
		final PoolAdminViewDTO pool=poolService.addPoolToUser(poolId,userId);
		
		return ResponseEntity.ok(pool);
	}
	
	@GetMapping("v1/admin/pool/{poolId}/removeuser/{userId}")
	public ResponseEntity<PoolAdminViewDTO> removePoolToUser(@PathVariable("poolId")int poolId,@PathVariable("userId")int userId){
		final PoolAdminViewDTO pool=poolService.removePoolToUser(poolId,userId);
		
		return ResponseEntity.ok(pool);
		
	}
	
	
	// slice?page=3&size=7 ----url slice den sonra gelecek kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/pool/slice")
	public ResponseEntity<List<PoolAdminViewDTO>> poolSlice(Pageable pageable){
		final List<PoolAdminViewDTO> pools=poolService.poolSlice(pageable);
		
		return ResponseEntity.ok(pools);
	}

}
