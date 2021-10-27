package com.havuzentity.havuzentitty.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.havuzentity.havuzentitty.dto.MaintenanceOperationAdminViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUserViewDTO;

public interface MaintenanceOperationService {

	MaintenanceOperationAdminViewDTO maintenanceOperationById(int id);

	List<MaintenanceOperationAdminViewDTO> getMaintenanceOperation();

	MaintenanceOperationAdminViewDTO createMaintenanceOperation(@Valid MaintenanceOperationCreateDTO maintenanceOperationCreateDTO);

	MaintenanceOperationAdminViewDTO updateMAintenmanceOperation(int id,MaintenanceOperationUpdateDTO maintenanceOperationUpdateDTO);

	void deleteMaintenanceOperation(int id);

	List<MaintenanceOperationAdminViewDTO> maintenanceOperationSlice(Pageable pageable);

	MaintenanceOperationUserViewDTO getUserMaintenanceOperationById(int id);

}
