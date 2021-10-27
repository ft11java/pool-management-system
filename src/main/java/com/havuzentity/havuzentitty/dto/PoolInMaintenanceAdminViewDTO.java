package com.havuzentity.havuzentitty.dto;



import java.io.Serializable;

import com.havuzentity.havuzentitty.model.Pool;

import lombok.Getter;

@Getter
public class PoolInMaintenanceAdminViewDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private int id;

	private String poolNumber;

	private String poolName;

	private int capacity;

	public PoolInMaintenanceAdminViewDTO(int id, String poolNumber, String poolName, int capacity) {
		
		this.id = id;
		this.poolNumber = poolNumber;
		this.poolName = poolName;
		this.capacity = capacity;
	}
	
	public static PoolInMaintenanceAdminViewDTO of(Pool pool) {
		return new PoolInMaintenanceAdminViewDTO(
				pool.getId(),
				pool.getPoolNumber(),
				pool.getPoolName(),
				pool.getCapacity());
	}
	

}
