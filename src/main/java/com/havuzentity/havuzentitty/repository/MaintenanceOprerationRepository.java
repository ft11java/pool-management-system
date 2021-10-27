package com.havuzentity.havuzentitty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.MaintenanceOperation;

@Repository
public interface MaintenanceOprerationRepository extends JpaRepository<MaintenanceOperation, Integer> {

}
