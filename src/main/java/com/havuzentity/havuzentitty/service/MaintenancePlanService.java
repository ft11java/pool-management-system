package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.MaintenancePlanCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUserViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanAdminViewDTO;

public interface MaintenancePlanService {

	MaintenancePlanAdminViewDTO getMaintenancePlanById(int id);

	
	List<MaintenancePlanAdminViewDTO> getMaintenancePlan();

	MaintenancePlanAdminViewDTO createMaintenancePlan(@Valid MaintenancePlanCreateDTO maintenancePlanCreateDTO);


	MaintenancePlanAdminViewDTO updateMaintenancePlan(int id, MaintenancePlanUpdateDTO maintenacePlanUpdateDTO);


	

	MaintenancePlanAdminViewDTO addMaintenancePlanToMaintenanceOperatin(int maintenancePlanId,
			int maintenanceOperationId);


	MaintenancePlanUserViewDTO getUserMaintenancePlanById(int id);


	List<MaintenancePlanAdminViewDTO> maintenancePlanSlice(Pageable pageable);


	MaintenancePlanAdminViewDTO removeMaintenancePlanToMaintenanceOperation(int maintenancePlanId,
			int maintenanceOperationId);


	void deleteMaintenancePlan(int id);


	


	
}
