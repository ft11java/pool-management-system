package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import com.havuzentity.havuzentitty.model.PoolType;

import lombok.Getter;

@Getter
public class PoolTypeUserViewDTO implements Serializable{
	
	
		private static final long serialVersionUID = 1L;
		
		
		private String poolTypeName;
		
		
		public PoolTypeUserViewDTO(String poolTypeName) {
			
			
			this.poolTypeName = poolTypeName;
		}

		public static PoolTypeUserViewDTO of(PoolType poolType) {
			
			return new PoolTypeUserViewDTO(poolType.getPoolTypeName());
		}
		
	}


