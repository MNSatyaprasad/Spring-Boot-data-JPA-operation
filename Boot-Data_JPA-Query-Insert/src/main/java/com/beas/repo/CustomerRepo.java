package com.beas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.beas.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	

	@Modifying
	@Transactional
	@Query(value = " insert into Customer values (name,adderess,amt)",nativeQuery = true)
	public int registerCustomer(String name,String adderess,double amt );
	
}
