package com.havuzentity.havuzentitty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.PoolUsageType;

@Repository
public interface PoolUsageTypeRepository extends JpaRepository<PoolUsageType, Integer> {

}
