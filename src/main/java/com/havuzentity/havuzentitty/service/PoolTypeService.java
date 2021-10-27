package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.PoolTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUserViewDTO;

public interface PoolTypeService {

	PoolTypeAdminViewDTO getPoolTypeAdminById(int id);

	PoolTypeUserViewDTO getPoolTypeUserById(int id);

	List<PoolTypeAdminViewDTO> getAllPoolType();

	PoolTypeAdminViewDTO createPoolType(@Valid PoolTypeCreateDTO poolTypeCreateDTO);

	PoolTypeAdminViewDTO updatePoolType(int id, PoolTypeUpdateDTO poolTypeUpdateDTO);

	void deletePoolType(int id);

	List<PoolTypeAdminViewDTO> poolTypeSlice(Pageable pageable);

}
