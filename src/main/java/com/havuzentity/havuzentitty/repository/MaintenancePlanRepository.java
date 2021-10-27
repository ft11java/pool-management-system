package com.havuzentity.havuzentitty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.MaintenancePlan;

@Repository
public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, Integer> {

}
