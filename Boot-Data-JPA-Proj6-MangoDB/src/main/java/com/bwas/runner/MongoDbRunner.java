package com.bwas.runner;

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
		Employee e = new Employee();
		e.setEname("Ramys");
		e.setEno(101);
		e.setSalary(5000.03);
		e.setEaddrs("Kolkata");
		//e.setIsVaccinated(true);

		String msg = service.saveEmployee(e);
		System.out.println(msg);
	}

}
