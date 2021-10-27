package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.MaintenancePlan;

import lombok.Getter;

@Getter
public class MaintenancePlanInPoolUserViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
private Date operationMade;
	
	private Date nextMaintenanceDate;
	
	private List<MaintenanceOperationUserViewDTO> maintenanceOperation;
	
	private int invoicePrice;

	public MaintenancePlanInPoolUserViewDTO(Date operationMade, Date nextMaintenanceDate,
			List<MaintenanceOperationUserViewDTO> maintenanceOperation, int invoicePrice) {
	
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.maintenanceOperation = maintenanceOperation;
		this.invoicePrice = invoicePrice;
	}
	
	public static MaintenancePlanInPoolUserViewDTO of (MaintenancePlan maintenancePlan ) {
		
		return new MaintenancePlanInPoolUserViewDTO(
				maintenancePlan.getOperationMade(),
				maintenancePlan.getNextMaintenanceDate(),
				maintenancePlan.getEnrolledMaintenanceOperation().stream().map(MaintenanceOperationUserViewDTO::of).collect(Collectors.toList()),
				maintenancePlan.getInvoicePrice()
				);
		
	}
	

}
