package com.bwas.runner;

import java.util.List;

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
		/*
		 * List<Object[]> list = service.showEmployeeDetailsByAddrs("Kolkata");
		 * list.forEach(row ->{ for(Object val : row) { System.out.println(val); }
		 * System.out.println(); });
		 */
		//service.fetchEmployeesByAddrs("Hyderabad").forEach(System.out::println);
		//service.fetchEmpAllByAddrs("Kolkata", "Ramys").forEach(System.out::println);
		
		service.showEmpAllDataBySalary(5000.00, 25000.00).forEach(s -> System.out.println(s));
	}

}
