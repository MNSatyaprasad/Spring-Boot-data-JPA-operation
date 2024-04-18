package com.bwas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.document.Employee;
import com.bwas.service.IEmployeeService;

@Component
public class MongoDbRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeService service;

	@Override
	public void run(String... args) throws Exception {

		service.searchByEmployeeInsalarayRange(5000.00, 30000.00).forEach(System.out::println);
	}



}
