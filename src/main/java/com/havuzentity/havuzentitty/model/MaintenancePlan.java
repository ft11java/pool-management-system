package com.havuzentity.havuzentitty.model;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "maintenance_plans")
public class MaintenancePlan {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="date_made")
	@Temporal(TemporalType.DATE)
	private Date operationMade;
	
	@Column(name="next_maintenance_date")
	@Temporal(TemporalType.DATE)
	private Date nextMaintenanceDate;
	
	
	@ManyToMany(/*cascade = CascadeType.ALL,*/fetch = FetchType.EAGER)
	@JoinTable(name="maintenance_plan_maintenance_operation", joinColumns=@JoinColumn(name="maintenance_plan_id"),
																inverseJoinColumns=@JoinColumn(name="maintennace_operation_id"))
	private Set<MaintenanceOperation> enrolledMaintenanceOperation=new HashSet<>();
	
	@Column(name="invoice_price")
	private int invoicePrice;

	@ManyToOne
	@JoinColumn(name="pool_id")
	private Pool pool;
	
	public MaintenancePlan(Date operationMade, Date nextMaintenanceDate,
			Set<MaintenanceOperation> list, int invoicePrice) {
		
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.enrolledMaintenanceOperation = list;
		this.invoicePrice = invoicePrice;
	}

	public MaintenancePlan(Date operationMade, Date nextMaintenanceDate, int invoicePrice) {
		
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.invoicePrice = invoicePrice;
	}

	public MaintenancePlan(Date operationMade, Date nextMaintenanceDate,
			 int invoicePrice, Pool pool) {
	
		this.operationMade = operationMade;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.invoicePrice = invoicePrice;
		this.pool = pool;
	}
	
	

	

	
	
	

}
