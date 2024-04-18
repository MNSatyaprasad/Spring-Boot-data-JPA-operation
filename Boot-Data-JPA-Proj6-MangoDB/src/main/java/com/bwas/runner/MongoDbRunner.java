package com.bwas.runner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.service.IEmployeeService;
import com.bwasdocument.Employee;

@Component
public class MongoDbRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeService service;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Employee e = new Employee(); e.setId("6618fda3c1810f2e03aafaf2");
		 * e.setEname("Rahul"); e.setEno(1050); e.setSalary(25000.03);
		 * e.setEaddrs("Kolkata"); e.setIsVaccinated(true);
		 * 
		 * String msg = service.updateEmployeee(e); System.out.println(msg);
		 */

		// service.showAll().forEach(e -> System.out.println(e));
		/*
		 * String msg = service.deleteById("6618fd1eeb68916b599fb208");
		 * System.out.println(msg);
		 */
		 Employee e = new Employee(); 
		  e.setEname("Ravi"); 
		  e.setEno(10990); 
		  e.setSalary(195000.03);
		  e.setEaddrs("Kadapa");
		  e.setIsVaccinated(true);
		String string =  service.saveIdValueusingUUUID(e);
		System.out.println(string);
	}

}
