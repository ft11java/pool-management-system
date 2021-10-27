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
@Table(name="user_titles")
public class UserTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_title_name", unique = true)
	private String userTitleName;
	

	public UserTitle(String userTitleName) {
		
		this.userTitleName = userTitleName;
	}
	
	
	


}


