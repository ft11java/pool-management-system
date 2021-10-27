package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.MaintenancePlan;

import lombok.Getter;

//Havuz sorgusu yapıldığında sitenin bütün ziyaretcilerinin görebileceği bakım planı

@Getter
public class MaintenancePlanViewAllDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Date operationMade;
	
	private List<MaintenanceOperationViewAllDTO> maintenanceOperationViewAllDTO;

	public MaintenancePlanViewAllDTO(Date operationMade,
			List<MaintenanceOperationViewAllDTO> maintenanceOperationViewAllDTO) {
	
		this.operationMade = operationMade;
		this.maintenanceOperationViewAllDTO = maintenanceOperationViewAllDTO;
	}
	
	public static MaintenancePlanViewAllDTO of(MaintenancePlan maintenancePlan) {
		
		return new MaintenancePlanViewAllDTO(
				maintenancePlan.getOperationMade(),
				maintenancePlan.getEnrolledMaintenanceOperation().stream().map(MaintenanceOperationViewAllDTO::of).collect(Collectors.toList())
				);
	}

}
