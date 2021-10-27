package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.PoolAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolViewAllDTO;
import com.havuzentity.havuzentitty.dto.PoolViewUserDTO;

public interface PoolService {

	PoolAdminViewDTO createPool(@Valid PoolCreateDTO poolCreateDTO);

	PoolAdminViewDTO getPoolById(int id);

	PoolViewUserDTO getUserPoolById(int id);

	List<PoolAdminViewDTO> getAllPool();

	PoolAdminViewDTO updatePool(int id, PoolUpdateDTO poolUpdateDTO);

	void deletePool(int id);

	List<PoolAdminViewDTO> poolSlice(Pageable pageable);

	PoolAdminViewDTO addPoolToUser(int poolId, int userId);

	PoolAdminViewDTO removePoolToUser(int poolId, int userId);

	PoolViewAllDTO getPoolViewAllVisitor(String poolNumber);

	List<PoolViewUserDTO> getUserPoolByUserName(String userName);

	PoolViewUserDTO getUserPoolByPoolNumber(String poolNumber);


		
		
	

}
