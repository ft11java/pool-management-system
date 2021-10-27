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
@Table(name="maintanence_operations")
public class MaintenanceOperation {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="operation_name")
	private String operationName;
	
	@Column(name="what_frequency")
	private String whatFrequency;
	
	@Column(name="unit_price")
	private int unitPrice;
	
	public MaintenanceOperation(String operationName, String whatFrequency, int unitPrice) {
		
		this.operationName = operationName;
		this.whatFrequency = whatFrequency;
		this.unitPrice = unitPrice;
	}



	

	
	
}
