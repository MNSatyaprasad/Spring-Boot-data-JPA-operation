package com.beas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.beas.repo.CustomerRepo;
@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Object list = repo.searchCustomerByName("joya"); Object data[] =
		 * (Object[])list; for(Object obj : data) {
		 * 
		 * System.out.println(obj); }
		 */
		System.out.println();
		System.out.println(repo.searchByCity("joya"));
		
		Object cust = repo.searchAggerateFunctions();
		
		Object data[] = (Object[])cust;
		for(Object obj : data) {
			System.out.println(obj);
		}
	}

}
