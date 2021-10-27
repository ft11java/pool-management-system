package com.havuzentity.havuzentitty.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.Pool;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Integer> {

	Optional<Pool> findByPoolNumber(String poolNumber);
	
	List<Pool> findByUsers_UserName(String userName);
	
	

}
