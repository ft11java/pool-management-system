package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.PoolType;

import lombok.Getter;

@Getter
public class PoolTypeAdminViewDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String poolTypeName;
	
	
	public PoolTypeAdminViewDTO(int id, String poolTypeName) {
		
		this.id = id;
		this.poolTypeName = poolTypeName;
	}

	public static PoolTypeAdminViewDTO of(PoolType poolType) {
		
		return new PoolTypeAdminViewDTO(poolType.getId(),poolType.getPoolTypeName());
	}
	
}
