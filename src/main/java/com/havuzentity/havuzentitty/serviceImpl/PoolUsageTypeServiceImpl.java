package com.havuzentity.havuzentitty.serviceImpl;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.havuzentity.havuzentitty.dto.PoolUsageTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUpdate;
import com.havuzentity.havuzentitty.dto.PoolUsageTypeUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;

import com.havuzentity.havuzentitty.model.PoolUsageType;
import com.havuzentity.havuzentitty.repository.PoolUsageTypeRepository;
import com.havuzentity.havuzentitty.service.PoolUsageTypeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PoolUsageTypeServiceImpl implements PoolUsageTypeService {
	
	private final PoolUsageTypeRepository poolUsageTypeRepository;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolUsageTypeAdminViewDTO getPoolUsageTypeAdminById(int id) {
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return PoolUsageTypeAdminViewDTO.of(poolUsageType);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolUsageTypeUserViewDTO poolUsageTypeUserById(int id) {
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return PoolUsageTypeUserViewDTO.of(poolUsageType);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PoolUsageTypeAdminViewDTO> getAllPoolUsageType() {
		
	
		return poolUsageTypeRepository.findAll().stream().map(PoolUsageTypeAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public PoolUsageTypeAdminViewDTO createPoolUsageType(@Valid PoolUsageTypeCreateDTO poolUsageTypeCreateViewDTO) {
		final PoolUsageType poolUsageType=poolUsageTypeRepository.save(new PoolUsageType(poolUsageTypeCreateViewDTO.getPoolUsageTypeName()));
		
		return PoolUsageTypeAdminViewDTO.of(poolUsageType);
	}

	@Override
	@Transactional
	public PoolUsageTypeAdminViewDTO updatePoolUsageType(int id, PoolUsageTypeUpdate poolUsageTypeUpdateDTO) {
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		poolUsageType.setPoolUsageTypeName(poolUsageTypeUpdateDTO.getPoolUsageTypeName());
		final PoolUsageType poolUsageTypeUpdate=poolUsageTypeRepository.save(poolUsageType);
		
		return PoolUsageTypeAdminViewDTO.of(poolUsageTypeUpdate);
	}

	@Override
	@Transactional
	public void deletePoolUsageType(int id) {
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		poolUsageTypeRepository.deleteById(poolUsageType.getId());
		
	}

	@Override
	public List<PoolUsageTypeAdminViewDTO> poolUsageTypeSlice(Pageable pageable) {
	
		return poolUsageTypeRepository.findAll(pageable).stream().map(PoolUsageTypeAdminViewDTO::of).collect(Collectors.toList());
	}
	
	

}
