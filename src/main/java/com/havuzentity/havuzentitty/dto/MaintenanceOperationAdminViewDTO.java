package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.MaintenanceOperation;

import lombok.Getter;

@Getter
public final class MaintenanceOperationAdminViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String operationName;
	private String whatFrequency;
	private int unitPrice;

	public MaintenanceOperationAdminViewDTO(int id,String operationName, String whatFrequency, int unitPrice) {
		this.id=id;
		this.operationName = operationName;
		this.whatFrequency = whatFrequency;
		this.unitPrice = unitPrice;
	}

	public static MaintenanceOperationAdminViewDTO of(MaintenanceOperation maintenanceOperation) {
		
		return new MaintenanceOperationAdminViewDTO(maintenanceOperation.getId(),maintenanceOperation.getOperationName(), 
				maintenanceOperation.getWhatFrequency(), maintenanceOperation.getUnitPrice());
	}

	

}
