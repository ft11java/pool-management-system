package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.havuzentity.havuzentitty.dto.MaintenanceOperationAdminViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;

import com.havuzentity.havuzentitty.model.MaintenanceOperation;

import com.havuzentity.havuzentitty.repository.MaintenanceOprerationRepository;
import com.havuzentity.havuzentitty.service.MaintenanceOperationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaintenanceOperationServiceImpl implements MaintenanceOperationService {

	private final MaintenanceOprerationRepository maintenanceOperationRepository;
	

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public MaintenanceOperationAdminViewDTO maintenanceOperationById(int id) {
		
		final MaintenanceOperation maintenanceOperation=maintenanceOperationRepository.findById(id)	
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		return  MaintenanceOperationAdminViewDTO.of(maintenanceOperation);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public MaintenanceOperationUserViewDTO getUserMaintenanceOperationById(int id) {
		final MaintenanceOperation maintenanceOperation=maintenanceOperationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return MaintenanceOperationUserViewDTO.of(maintenanceOperation);
	}


	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<MaintenanceOperationAdminViewDTO> getMaintenanceOperation() {
	
		return maintenanceOperationRepository.findAll().stream().map(MaintenanceOperationAdminViewDTO::of).collect(Collectors.toList());
	}


	@Override
	@Transactional
	public MaintenanceOperationAdminViewDTO createMaintenanceOperation(MaintenanceOperationCreateDTO maintenanceOperationCreateDTO) {
		final MaintenanceOperation maintenanceOperation=maintenanceOperationRepository.save(new MaintenanceOperation(maintenanceOperationCreateDTO.getOperationName(),
				maintenanceOperationCreateDTO.getWhatFrequency(),maintenanceOperationCreateDTO.getUnitPrice()));
		return MaintenanceOperationAdminViewDTO.of(maintenanceOperation);
	}


	@Override
	@Transactional
	public MaintenanceOperationAdminViewDTO updateMAintenmanceOperation(int id,
			MaintenanceOperationUpdateDTO maintenanceOperationUpdateDTO) {
		
		final MaintenanceOperation maintenanveOperation=maintenanceOperationRepository.findById(id)
				.orElseThrow(()->new NotFoundException("Not Found Exception"));
		maintenanveOperation.setOperationName(maintenanceOperationUpdateDTO.getOperationName());
		maintenanveOperation.setWhatFrequency(maintenanceOperationUpdateDTO.getWhatFrequency());
		maintenanveOperation.setUnitPrice(maintenanceOperationUpdateDTO.getUnitPrice());
		
		final MaintenanceOperation updateMaintenanceOperatin=maintenanceOperationRepository.save(maintenanveOperation);
		
		return MaintenanceOperationAdminViewDTO.of(updateMaintenanceOperatin);
	}

	@Override
	@Transactional
	public void deleteMaintenanceOperation(int id) {
		final MaintenanceOperation maintenanceOperation=maintenanceOperationRepository.findById(id)
				.orElseThrow(()->new NotFoundException("Not Fount Exception"));
		maintenanceOperationRepository.deleteById(maintenanceOperation.getId());	
	}


	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<MaintenanceOperationAdminViewDTO> maintenanceOperationSlice(Pageable pageable) {
		
		return maintenanceOperationRepository.findAll(pageable).stream().map(MaintenanceOperationAdminViewDTO::of).collect(Collectors.toList());
	}


	
	
	

}
