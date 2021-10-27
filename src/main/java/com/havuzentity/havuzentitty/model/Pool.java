package com.havuzentity.havuzentitty.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "pools")
public class Pool {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
		
		@Column(name = "pool_Number",unique = true)
		private String poolNumber;
	   
	    @Column(name = "poolName")
	    private String poolName;
	    
	    @Column(name="capacity")
	    private int capacity;
	    
	    @Column(name="registration_date")
		@Temporal(TemporalType.DATE)
		private Date resigtrationDate;
	    
	    @ManyToMany(/*cascade = CascadeType.ALL,*/fetch = FetchType.LAZY)
		@JoinTable(name="pool_user", joinColumns=@JoinColumn(name="pool_id"),
																	inverseJoinColumns=@JoinColumn(name="user_id"))
		private Set<User> users=new HashSet<>();
	    
	    @ManyToOne(/*cascade = CascadeType.ALL,*/fetch = FetchType.EAGER)
	    @JoinColumn(name="pool_type_id")
	    private PoolType poolType;
	    
	    @ManyToOne(/*cascade = CascadeType.ALL,*/fetch = FetchType.EAGER)
	    @JoinColumn(name="pool_usage_type_id")
	    private PoolUsageType poolUsageType;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name="address_id")
	    private Address address;
	   
	    @OneToMany(mappedBy="pool")
	    private Set<MaintenancePlan> maintenancePlans=new HashSet<MaintenancePlan>();

		public Pool(String poolNumber, String poolName, int capacity, Date resigtrationDate, 
				PoolType poolType, PoolUsageType poolUsageType, Address address) {
		
			this.poolNumber = poolNumber;
			this.poolName = poolName;
			this.capacity = capacity;
			this.resigtrationDate = resigtrationDate;
			this.poolType = poolType;
			this.poolUsageType = poolUsageType;
			this.address = address;
		}

		
	  public void addUser (User user) {
		  this.users.add(user);
		  user.getPools().add(this);
		  
	  }
	  
	  public void removeUser(User  user) {
		  this.users.remove(user);
		  user.getPools().remove(this);
	  }
}
