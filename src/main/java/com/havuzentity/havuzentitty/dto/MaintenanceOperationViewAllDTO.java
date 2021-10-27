package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.MaintenanceOperation;

import lombok.Getter;

//Havuz sorgulamada bütün site ziyaretcilerinin görebilecegi bakım operasyon bilgileri

@Getter
public class MaintenanceOperationViewAllDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String operationName;
	private String whatFrequency;
	
	
	public MaintenanceOperationViewAllDTO(String operationName, String whatFrequency) {
	
		this.operationName = operationName;
		this.whatFrequency = whatFrequency;
	}
	
	public static MaintenanceOperationViewAllDTO of(MaintenanceOperation maintenanceOperation) {
		return new MaintenanceOperationViewAllDTO(maintenanceOperation.getOperationName(), maintenanceOperation.getWhatFrequency());
	}
	
	

}
