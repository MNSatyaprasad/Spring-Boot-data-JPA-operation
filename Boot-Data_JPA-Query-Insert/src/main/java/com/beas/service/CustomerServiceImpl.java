package com.beas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beas.repo.CustomerRepo;
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepo repo;
	@Override
	public int saveCustomer(String name, String adderess, double amt) {
		
	int count =	repo.registerCustomer(name, adderess, amt);
		return count;
	}

}
