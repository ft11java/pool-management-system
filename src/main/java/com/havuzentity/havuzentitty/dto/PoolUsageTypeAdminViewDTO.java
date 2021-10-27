package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.PoolUsageType;

import lombok.Getter;

@Getter
public class PoolUsageTypeAdminViewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String poolUsageTypeName;
	
	
	public PoolUsageTypeAdminViewDTO(int id, String poolUsageTypeName) {
		this.id = id;
		this.poolUsageTypeName = poolUsageTypeName;
	}
	
	public static PoolUsageTypeAdminViewDTO of(PoolUsageType poolUsageType) {
		
		return new PoolUsageTypeAdminViewDTO(poolUsageType.getId(), poolUsageType.getPoolUsageTypeName());
	}
	
}
