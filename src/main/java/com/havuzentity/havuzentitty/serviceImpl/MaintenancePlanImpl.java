package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.havuzentity.havuzentitty.dto.MaintenancePlanCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUserViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanAdminViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;
import com.havuzentity.havuzentitty.model.MaintenanceOperation;
import com.havuzentity.havuzentitty.model.MaintenancePlan;
import com.havuzentity.havuzentitty.model.Pool;
import com.havuzentity.havuzentitty.repository.MaintenanceOprerationRepository;
import com.havuzentity.havuzentitty.repository.MaintenancePlanRepository;
import com.havuzentity.havuzentitty.repository.PoolRepository;
import com.havuzentity.havuzentitty.service.MaintenancePlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaintenancePlanImpl implements MaintenancePlanService {

	private final MaintenancePlanRepository maintenancePlanRepository;
	private final PoolRepository poolRepository;

	private final MaintenanceOprerationRepository maintenanceOperationRepositoriy;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public MaintenancePlanAdminViewDTO getMaintenancePlanById(int id) {
		final MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return MaintenancePlanAdminViewDTO.of(maintenancePlan);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public MaintenancePlanUserViewDTO getUserMaintenancePlanById(int id) {
		final MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return MaintenancePlanUserViewDTO.of(maintenancePlan);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<MaintenancePlanAdminViewDTO> getMaintenancePlan() {

		return maintenancePlanRepository.findAll().stream().map(MaintenancePlanAdminViewDTO::of)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public MaintenancePlanAdminViewDTO createMaintenancePlan(@Valid MaintenancePlanCreateDTO maintenancePlanCreateDTO) {
		final Pool pool=poolRepository.findById(maintenancePlanCreateDTO.getPoolId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		final MaintenancePlan maintenacePlan = new MaintenancePlan(
				maintenancePlanCreateDTO.getOperationMade(),
				maintenancePlanCreateDTO.getNextMaintenanceDate(),
				maintenancePlanCreateDTO.getInvoicePrice(),
				pool);
		maintenancePlanRepository.save(maintenacePlan);
				
		return MaintenancePlanAdminViewDTO.of(maintenacePlan);
	}

	@Override
	@Transactional
	public MaintenancePlanAdminViewDTO updateMaintenancePlan(int id,
			MaintenancePlanUpdateDTO maintenancePlanUpdateDTO) {

		final MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		final Pool pool=poolRepository.findById(maintenancePlanUpdateDTO.getPoolId())
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		maintenancePlan.setOperationMade(maintenancePlanUpdateDTO.getOperationMade());
		maintenancePlan.setNextMaintenanceDate(maintenancePlanUpdateDTO.getNextMaintenanceDate());
		maintenancePlan.setInvoicePrice(maintenancePlanUpdateDTO.getInvoicePrice());
		maintenancePlan.setPool(pool);

		final MaintenancePlan updateMaintenancePlan = maintenancePlanRepository.save(maintenancePlan);
		return MaintenancePlanAdminViewDTO.of(updateMaintenancePlan);
	}

	@Override
	@Transactional
	public void deleteMaintenancePlan(int id) {
		final MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		maintenancePlanRepository.deleteById(maintenancePlan.getId());
		
	}
	
	@Override
	@Transactional
	public MaintenancePlanAdminViewDTO addMaintenancePlanToMaintenanceOperatin(int maintenancePlanId,
			int maintenanceOperationId) {

		MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(maintenancePlanId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		MaintenanceOperation maintenanceOperation = maintenanceOperationRepositoriy.findById(maintenanceOperationId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		maintenancePlan.getEnrolledMaintenanceOperation().add(maintenanceOperation);
		final MaintenancePlan maintenancePlanView = maintenancePlanRepository.save(maintenancePlan);

		return MaintenancePlanAdminViewDTO.of(maintenancePlanView);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public MaintenancePlanAdminViewDTO removeMaintenancePlanToMaintenanceOperation(int maintenancePlanId,
			int maintenanceOperationId) {

		MaintenancePlan maintenancePlan = maintenancePlanRepository.findById(maintenancePlanId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		MaintenanceOperation maitenanceOperation = maintenanceOperationRepositoriy.findById(maintenanceOperationId)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		maintenancePlan.getEnrolledMaintenanceOperation().remove(maitenanceOperation);
		final MaintenancePlan maintenancePlanView = maintenancePlanRepository.save(maintenancePlan);

		return MaintenancePlanAdminViewDTO.of(maintenancePlanView);

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<MaintenancePlanAdminViewDTO> maintenancePlanSlice(Pageable pageable) {

		return maintenancePlanRepository.findAll(pageable).stream().map(MaintenancePlanAdminViewDTO::of)
				.collect(Collectors.toList());
	}

	

}
