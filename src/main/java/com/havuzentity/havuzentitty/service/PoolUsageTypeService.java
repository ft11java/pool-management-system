package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.PoolUsageTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUpdate;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUserViewDTO;

public interface PoolUsageTypeService {

	PoolUsageTypeAdminViewDTO getPoolUsageTypeAdminById(int id);

	PoolUsageTypeUserViewDTO poolUsageTypeUserById(int id);

	List<PoolUsageTypeAdminViewDTO> getAllPoolUsageType();

	PoolUsageTypeAdminViewDTO createPoolUsageType(@Valid PoolUsageTypeCreateDTO poolUsageTypeCreateViewDTO);

	PoolUsageTypeAdminViewDTO updatePoolUsageType(int id, PoolUsageTypeUpdate poolUsageTypeUpdate);

	void deletePoolUsageType(int id);

	List<PoolUsageTypeAdminViewDTO> poolUsageTypeSlice(Pageable pageable);



}
