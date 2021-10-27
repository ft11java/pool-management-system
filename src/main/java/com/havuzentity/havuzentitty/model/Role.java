package com.havuzentity.havuzentitty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
	public class Role {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "role_id")
	    private int id;
	    
	    @Column(name = "role", unique = true)
	   // @Enumerated(EnumType.STRING)
	    private String  role;

		public Role(String role) {
			
			this.role = role;
		}
		
	    
	   
	    
	    
	    
	}


