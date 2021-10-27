package com.havuzentity.havuzentitty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.PoolType;

@Repository
public interface PoolTypeRepository extends JpaRepository<PoolType, Integer> {

}
