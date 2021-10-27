package com.havuzentity.havuzentitty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havuzentity.havuzentitty.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
