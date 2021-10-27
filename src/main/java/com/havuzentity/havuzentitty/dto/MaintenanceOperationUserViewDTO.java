package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.MaintenanceOperation;

import lombok.Getter;

@Getter
public class MaintenanceOperationUserViewDTO implements Serializable{
	private static final long serialVersionUID = 1L;


	private String operationName;
	private String whatFrequency;
	private int unitPrice;

	public MaintenanceOperationUserViewDTO(String operationName, String whatFrequency, int unitPrice) {
	
		this.operationName = operationName;
		this.whatFrequency = whatFrequency;
		this.unitPrice = unitPrice;
	}

	public static MaintenanceOperationUserViewDTO of(MaintenanceOperation maintenanceOperation) {
		
		return new MaintenanceOperationUserViewDTO(maintenanceOperation.getOperationName(), 
				maintenanceOperation.getWhatFrequency(), maintenanceOperation.getUnitPrice());
	}

	

}



