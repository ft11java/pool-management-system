package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

import com.havuzentity.havuzentitty.model.Address;

import lombok.Data;

@Data
public class PoolCreateDTO implements Serializable{


	private static final long serialVersionUID = 1L;


	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String poolNumber;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private String poolName;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int capacity;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private Date resigtrationDate;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int usersId;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int  poolTypeId;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private int poolUsageTypeId;
	
	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	private Address address;
}
