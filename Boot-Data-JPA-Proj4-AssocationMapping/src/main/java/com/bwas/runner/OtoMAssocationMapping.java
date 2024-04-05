package com.bwas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.service.IIOToMAssocationMapping;
@Component
public class OtoMAssocationMapping implements CommandLineRunner {

	@Autowired
	private IIOToMAssocationMapping service;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		//service.saveDataUsingParesnt();
		//service.saveDataUsingChild();
		//service.loadDataUsingParent();
		//service.loadDataUsingChild();

		//String msg = service.deleteByPerson(103);
		//System.out.println(msg);
		
		String msg = service.deleteAllPhoneNumberOfPerson(103);
		System.out.println(msg);
		
		//service.addingNewChildExstingParent(104);
	}

}
