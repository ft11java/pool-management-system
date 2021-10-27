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
@Table(name="pool_types")
public class PoolType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pool_type_name", unique = true)
	private String poolTypeName;

	public PoolType(String poolTypeName) {
	
		this.poolTypeName = poolTypeName;
	}
	
	

}
