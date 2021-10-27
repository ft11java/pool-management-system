package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.Pool;

import lombok.Getter;

@Getter
public class PoolViewUserDTO  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	 
	   
	   private String poolNumber;
	   
	    private String poolName;
	    
	    private int capacity;
	    
	    private Date resigtrationDate;
	    
	    private List<UserInPoolViewUserDTO> users;
	    
	    private PoolTypeUserViewDTO poolType;
	    
	    private PoolUsageTypeUserViewDTO poolUsageType;
	    
	    private AddressUserViewDTO address;
	    
	    private List<MaintenancePlanInPoolUserViewDTO> maintenancePlans;

		 
	    public PoolViewUserDTO(String poolNumber, String poolName, int capacity, Date resigtrationDate,
				List<UserInPoolViewUserDTO> users, PoolTypeUserViewDTO poolType, PoolUsageTypeUserViewDTO poolUsageType,
				AddressUserViewDTO address, List<MaintenancePlanInPoolUserViewDTO> maintenancePlans) {
		
			this.poolNumber = poolNumber;
			this.poolName = poolName;
			this.capacity = capacity;
			this.resigtrationDate = resigtrationDate;
			this.users = users;
			this.poolType = poolType;
			this.poolUsageType = poolUsageType;
			this.address = address;
			this.maintenancePlans = maintenancePlans;
		}
	    
		public static PoolViewUserDTO of (Pool pool) {
			
			return new PoolViewUserDTO(
					pool.getPoolNumber(),
					pool.getPoolName(),
					pool.getCapacity(),
					pool.getResigtrationDate(),
					pool.getUsers().stream().map(UserInPoolViewUserDTO::of).collect(Collectors.toList()),
					PoolTypeUserViewDTO.of(pool.getPoolType()),
					PoolUsageTypeUserViewDTO.of(pool.getPoolUsageType()), 
					AddressUserViewDTO.of(pool.getAddress()),
					pool.getMaintenancePlans().stream().map(MaintenancePlanInPoolUserViewDTO::of).collect(Collectors.toList())
					);
			
		}



		
	    
	

}
