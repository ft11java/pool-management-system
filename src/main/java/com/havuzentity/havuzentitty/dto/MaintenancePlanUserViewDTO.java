package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.havuzentity.havuzentitty.model.MaintenancePlan;

import lombok.Getter;

@Getter
public class MaintenancePlanUserViewDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Date operationMade;
	
	private Date nextMaintenanceDate;
	
	private List<MaintenanceOperationUserViewDTO> maintenanceOperation;
	
	private int invoicePrice;

	public MaintenancePlanUserViewDTO(Date operationMade, Date nextMaintenanceDate,
			List<MaintenanceOperationUserViewDTO> maintenanceOperation, int invoicePrice) {
		super();
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.maintenanceOperation = maintenanceOperation;
		this.invoicePrice = invoicePrice;
	}

	public static MaintenancePlanUserViewDTO of (MaintenancePlan maintenancePlan) {
		
		return new MaintenancePlanUserViewDTO(
				maintenancePlan.getOperationMade(),
				maintenancePlan.getNextMaintenanceDate(),
				maintenancePlan.getEnrolledMaintenanceOperation().stream().map(MaintenanceOperationUserViewDTO::of).collect(Collectors.toList()),
				maintenancePlan.getInvoicePrice() );
	}



	
	
	

}
