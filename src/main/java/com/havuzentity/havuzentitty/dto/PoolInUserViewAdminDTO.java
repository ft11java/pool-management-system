package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Pool;

import lombok.Getter;

@Getter
public class PoolInUserViewAdminDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String poolNumber;

	private String poolName;

	public PoolInUserViewAdminDTO(int id, String poolNumber, String poolName) {
		
		this.id = id;
		this.poolNumber = poolNumber;
		this.poolName = poolName;
	}
	
	public static PoolInUserViewAdminDTO of (Pool pool) {
		
		return new PoolInUserViewAdminDTO(
				pool.getId(),
				pool.getPoolNumber(),
				pool.getPoolName());
	}	
	
}
