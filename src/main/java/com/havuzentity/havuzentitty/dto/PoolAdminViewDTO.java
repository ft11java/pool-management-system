package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.havuzentity.havuzentitty.model.Address;
import com.havuzentity.havuzentitty.model.MaintenancePlan;
import com.havuzentity.havuzentitty.model.Pool;
import com.havuzentity.havuzentitty.model.PoolType;
import com.havuzentity.havuzentitty.model.PoolUsageType;


import lombok.Getter;

@Getter
public class PoolAdminViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String poolNumber;

	private String poolName;

	private int capacity;

	private Date resigtrationDate;

	private List<UserInPoolViewAdminDTO> users;

	private PoolType poolType;

	private PoolUsageType poolUsageType;

	private Address address;

	private List<MaintenancePlanInPoolAdminViewDTO> maintenancePlans ;

	public PoolAdminViewDTO(int id, String poolNumber, String poolName, int capacity, Date resigtrationDate,
			List<UserInPoolViewAdminDTO> users, PoolType poolType, PoolUsageType poolUsageType, Address address,
			Set<MaintenancePlan> maintenancePlans) {

		this.id = id;
		this.poolNumber = poolNumber;
		this.poolName = poolName;
		this.capacity = capacity;
		this.resigtrationDate = resigtrationDate;
		this.users = users;
		this.poolType = poolType;
		this.poolUsageType = poolUsageType;
		this.address = address;
		this.maintenancePlans = maintenancePlans.stream().map(MaintenancePlanInPoolAdminViewDTO::of).collect(Collectors.toList());
	}

	public static PoolAdminViewDTO of(Pool pool) {

		return new PoolAdminViewDTO(
				pool.getId(),
				pool.getPoolNumber(),
				pool.getPoolName(),
				pool.getCapacity(),
				pool.getResigtrationDate(),
				pool.getUsers().stream().map(UserInPoolViewAdminDTO::of).collect(Collectors.toList()),
				pool.getPoolType(),
				pool.getPoolUsageType(),
				pool.getAddress(),
				pool.getMaintenancePlans());
	}

}
