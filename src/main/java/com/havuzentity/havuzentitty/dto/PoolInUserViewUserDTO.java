package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Pool;

import lombok.Getter;

@Getter
public class PoolInUserViewUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String poolNumber;

	private String poolName;

	public PoolInUserViewUserDTO(String poolNumber, String poolName) {
	
		this.poolNumber = poolNumber;
		this.poolName = poolName;
	}
	
	public static PoolInUserViewUserDTO of(Pool pool) {
		
		return new PoolInUserViewUserDTO(
				pool.getPoolNumber(),
				pool.getPoolName()
				);
	}

	
}
