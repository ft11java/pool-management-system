package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.PoolUsageType;

import lombok.Getter;

@Getter
public class PoolUsageTypeUserViewDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String poolUsageTypeName;

	public PoolUsageTypeUserViewDTO(String poolUsageTypeName) {
	
		this.poolUsageTypeName = poolUsageTypeName;
	}
	
	public static PoolUsageTypeUserViewDTO of(PoolUsageType poolUsageType) {
		
		return new PoolUsageTypeUserViewDTO(poolUsageType.getPoolUsageTypeName());
	}
	

}
