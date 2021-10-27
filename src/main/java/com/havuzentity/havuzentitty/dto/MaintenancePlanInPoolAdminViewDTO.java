package com.havuzentity.havuzentitty.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;


import com.havuzentity.havuzentitty.model.MaintenancePlan;

import lombok.Getter;

@Getter
public class MaintenancePlanInPoolAdminViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private Date operationMade;
	
	private Date nextMaintenanceDate;
	
	private List<MaintenanceOperationAdminViewDTO> maintenanceOperation;
	
	private int invoicePrice;

	public MaintenancePlanInPoolAdminViewDTO(int id, Date operationMade, Date nextMaintenanceDate,
			List<MaintenanceOperationAdminViewDTO> maintenanceOperation, int invoicePrice) {
		
		this.id = id;
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.maintenanceOperation = maintenanceOperation;
		this.invoicePrice = invoicePrice;
	}
	
	public static MaintenancePlanInPoolAdminViewDTO of(MaintenancePlan maintenancePlan) {
		
		return new MaintenancePlanInPoolAdminViewDTO(
				maintenancePlan.getId(),
				maintenancePlan.getOperationMade(),
				maintenancePlan.getNextMaintenanceDate(),
				maintenancePlan.getEnrolledMaintenanceOperation().stream().map(MaintenanceOperationAdminViewDTO::of).collect(Collectors.toList()),
				maintenancePlan.getInvoicePrice());
		
	}

	
	

}
