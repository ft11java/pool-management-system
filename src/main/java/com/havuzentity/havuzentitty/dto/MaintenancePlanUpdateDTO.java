package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;


import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
public class MaintenancePlanUpdateDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private Date operationMade;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private Date nextMaintenanceDate;
	
		
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int invoicePrice;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int poolId;

}
