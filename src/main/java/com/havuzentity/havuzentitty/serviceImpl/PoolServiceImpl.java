package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havuzentity.havuzentitty.dto.PoolAdminViewDTO;
import com.havuzentity.havuzentitty.dto.PoolCreateDTO;
import com.havuzentity.havuzentitty.dto.PoolUpdateDTO;
import com.havuzentity.havuzentitty.dto.PoolViewAllDTO;
import com.havuzentity.havuzentitty.dto.PoolViewUserDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.Pool;
import com.havuzentity.havuzentitty.model.PoolType;
import com.havuzentity.havuzentitty.model.PoolUsageType;
import com.havuzentity.havuzentitty.model.User;
import com.havuzentity.havuzentitty.repository.PoolRepository;
import com.havuzentity.havuzentitty.repository.PoolTypeRepository;
import com.havuzentity.havuzentitty.repository.PoolUsageTypeRepository;
import com.havuzentity.havuzentitty.repository.UserRepository;
import com.havuzentity.havuzentitty.service.PoolService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PoolServiceImpl implements PoolService {
	
	private final PoolRepository poolRepository;
	private final UserRepository userRepository;
	private final PoolTypeRepository poolTypeRepository;
	private final PoolUsageTypeRepository poolUsageTypeRepository;
	
	
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolAdminViewDTO getPoolById(int id) {
		final Pool pool=poolRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return PoolAdminViewDTO.of(pool);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolViewUserDTO getUserPoolById(int id) {
		final Pool pool=poolRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return PoolViewUserDTO.of(pool);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List <PoolViewUserDTO> getUserPoolByUserName(String userName) {
		 return poolRepository.findByUsers_UserName(userName).stream().map(PoolViewUserDTO::of).collect(Collectors.toList());
					
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolViewUserDTO getUserPoolByPoolNumber(String poolNumber) {
		final Pool pool=poolRepository.findByPoolNumber(poolNumber).
				orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return PoolViewUserDTO.of(pool);
	}


	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PoolAdminViewDTO> getAllPool() {
		
		return poolRepository.findAll().stream().map(PoolAdminViewDTO::of).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PoolViewAllDTO getPoolViewAllVisitor(String poolNumber) {
		final Pool pool=poolRepository.findByPoolNumber(poolNumber)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return PoolViewAllDTO.of(pool);
	}
	
	@Override
	@Transactional
	public PoolAdminViewDTO createPool(@Valid PoolCreateDTO poolCreateDTO) {
		final User user=userRepository.findById(poolCreateDTO.getUsersId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception user"));
	
		final PoolType poolType=poolTypeRepository.findById(poolCreateDTO.getPoolTypeId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception poolType"));
		
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(poolCreateDTO.getPoolUsageTypeId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception poolUsageType"));
		
		final Pool pool=new Pool(
				poolCreateDTO.getPoolNumber(),
				poolCreateDTO.getPoolName(),
				poolCreateDTO.getCapacity(),
				poolCreateDTO.getResigtrationDate(),
				poolType,
				poolUsageType,
				poolCreateDTO.getAddress()
				);
		pool.addUser(user);
		poolRepository.save(pool);
		
		return PoolAdminViewDTO.of(pool);
	}

	@Override
	@Transactional
	public PoolAdminViewDTO updatePool(int id, PoolUpdateDTO poolUpdateDTO) {
		final Pool pool=poolRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		final PoolType poolType=poolTypeRepository.findById(poolUpdateDTO.getPoolTypeId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		final PoolUsageType poolUsageType=poolUsageTypeRepository.findById(poolUpdateDTO.getPoolUsageTypeId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		pool.setPoolNumber(poolUpdateDTO.getPoolNumber());
		pool.setPoolName(poolUpdateDTO.getPoolName());
		pool.setCapacity(poolUpdateDTO.getCapacity());
		pool.setResigtrationDate(poolUpdateDTO.getResigtrationDate());
		pool.setPoolType(poolType);
		pool.setPoolUsageType(poolUsageType);
		//pool.setAddress(poolUpdateDTO.getAddress());
		pool.getAddress().setAddress(poolUpdateDTO.getAddress().getAddress());
		pool.getAddress().setStreet(poolUpdateDTO.getAddress().getStreet());
		pool.getAddress().setNeighborhood(poolUpdateDTO.getAddress().getNeighborhood());
		pool.getAddress().setDistrict(poolUpdateDTO.getAddress().getDistrict());
		pool.getAddress().setCity(poolUpdateDTO.getAddress().getCity());
		final Pool poolUpdate=poolRepository.save(pool);
		
		return PoolAdminViewDTO.of(poolUpdate);
	}

	@Override
	@Transactional
	public void deletePool(int id) {
		final Pool pool=poolRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		poolRepository.deleteById(pool.getId());
		
	}


	@Override
	@Transactional
	public PoolAdminViewDTO addPoolToUser(int poolId, int userId) {
		final Pool pool=poolRepository.findById(poolId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final User user=userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		pool.addUser(user);
		poolRepository.save(pool);
		userRepository.save(user);
		
		return PoolAdminViewDTO.of(pool);
	}

	@Override
	@Transactional
	public PoolAdminViewDTO removePoolToUser(int poolId, int userId) {
		final Pool pool=poolRepository.findById(poolId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final User user=userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		pool.removeUser(user);
		poolRepository.save(pool);
		userRepository.save(user);
		
		return PoolAdminViewDTO.of(pool);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PoolAdminViewDTO> poolSlice(Pageable pageable) {
		
		return poolRepository.findAll(pageable).stream().map(PoolAdminViewDTO::of).collect(Collectors.toList());
	}

	

	
	

}
