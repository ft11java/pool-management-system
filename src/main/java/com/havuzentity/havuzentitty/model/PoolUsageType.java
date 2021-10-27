package com.havuzentity.havuzentitty.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="poll_usage_types")

public class PoolUsageType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pool_usage_type_name", unique = true)
	private String poolUsageTypeName;

	

	public PoolUsageType(String poolUsageTypeName) {
		
		this.poolUsageTypeName = poolUsageTypeName;
	}
	
	
	


}
