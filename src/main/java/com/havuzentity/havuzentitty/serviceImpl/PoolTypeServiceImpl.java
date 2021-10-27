package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havuzentity.havuzentitty.dto.PoolTypeAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolTypeUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.PoolType;

import com.havuzentity.havuzentitty.repository.PoolTypeRepository;
import com.havuzentity.havuzentitty.service.PoolTypeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PoolTypeServiceImpl implements PoolTypeService {

	private final PoolTypeRepository poolTypeRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolTypeAdminViewDTO getPoolTypeAdminById(int id) {

		final PoolType poolType = poolTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return PoolTypeAdminViewDTO.of(poolType);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolTypeUserViewDTO getPoolTypeUserById(int id) {
		final PoolType poolType = poolTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return PoolTypeUserViewDTO.of(poolType);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PoolTypeAdminViewDTO> getAllPoolType() {

		return poolTypeRepository.findAll().stream().map(PoolTypeAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public PoolTypeAdminViewDTO createPoolType(@Valid PoolTypeCreateDTO poolTypeCreateDTO) {

		final PoolType poolType = poolTypeRepository.save(new PoolType(poolTypeCreateDTO.getPoolTypeName()));

		return PoolTypeAdminViewDTO.of(poolType);

	}

	@Override
	@Transactional
	public PoolTypeAdminViewDTO updatePoolType(int id, PoolTypeUpdateDTO poolTypeUpdateDTO) {
		final PoolType poolType = poolTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		poolType.setPoolTypeName(poolTypeUpdateDTO.getPoolTypeName());

		final PoolType poolTypeUpdate = poolTypeRepository.save(poolType);

		return PoolTypeAdminViewDTO.of(poolTypeUpdate);
	}

	@Override
	@Transactional
	public void deletePoolType(int id) {
		final PoolType poolType = poolTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		poolTypeRepository.deleteById(poolType.getId());

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PoolTypeAdminViewDTO> poolTypeSlice(Pageable pageable) {

		return poolTypeRepository.findAll(pageable).stream().map(PoolTypeAdminViewDTO::of).collect(Collectors.toList());
	}

}
