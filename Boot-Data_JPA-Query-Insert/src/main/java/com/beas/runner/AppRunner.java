package com.beas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.beas.repo.CustomerRepo;
import com.beas.repo.IAddress;
import com.beas.service.CustomerServiceImpl;
@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
		
	int v=	service.saveCustomer("Urbhasi", "kolkata", 25000.36);
		System.out.println(v);
	}

}
