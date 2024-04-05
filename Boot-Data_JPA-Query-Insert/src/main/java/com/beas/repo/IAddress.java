package com.beas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beas.entity.Address;

public interface IAddress extends JpaRepository<Address, Integer> {

	

}
