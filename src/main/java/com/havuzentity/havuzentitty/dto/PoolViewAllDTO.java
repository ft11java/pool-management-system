package com.havuzentity.havuzentitty.dto;


import java.io.Serializable;
import java.util.List;

import java.util.stream.Collectors;


import com.havuzentity.havuzentitty.model.Pool;

import lombok.Getter;

@Getter
public class PoolViewAllDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 
	    private String poolNumber;
	   
	    private String poolName;
	    
	    private int capacity;
	    
	    private PoolTypeUserViewDTO poolType;
	    
	    private PoolUsageTypeUserViewDTO poolUsageType;
	    
	    private List<MaintenancePlanViewAllDTO> maintenancePlanViewAllDTO;

		public PoolViewAllDTO(String poolNumber, String poolName, int capacity, PoolTypeUserViewDTO poolType,
				PoolUsageTypeUserViewDTO poolUsageType, List<MaintenancePlanViewAllDTO> maintenancePlanViewAllDTO) {
		
			this.poolNumber = poolNumber;
			this.poolName = poolName;
			this.capacity = capacity;
			this.poolType = poolType;
			this.poolUsageType = poolUsageType;
			this.maintenancePlanViewAllDTO = maintenancePlanViewAllDTO;
		}
	    
		public static PoolViewAllDTO of (Pool pool) {
			
			return new PoolViewAllDTO(
					pool.getPoolNumber(),
					pool.getPoolName(),
					pool.getCapacity(),
					PoolTypeUserViewDTO.of(pool.getPoolType()),
					PoolUsageTypeUserViewDTO.of(pool.getPoolUsageType()),
					pool.getMaintenancePlans().stream().map(MaintenancePlanViewAllDTO::of).collect(Collectors.toList())
					);
		}
	    

		
	    
	
	    

}
