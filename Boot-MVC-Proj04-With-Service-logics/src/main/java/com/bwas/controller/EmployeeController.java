package com.bwas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bwas.entity.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/")
	public String employeeReport(Map<String, Object> map) {
		
		Employee e = new Employee();
		e.seteNo(1002);
		e.seteName("Rahul");
		e.setEmpSlary(25000.23);
		e.setIsVanccinated(true);
		map.put("emp", e);
		
		return "report";
	}
	@GetMapping("/report")
	public String showEmployessInaTable(Map<String, Object> map) {
		
		List<Employee> list = List.of(new Employee(1005, "Raju",5400.02 , false),
				new Employee(1006, "satya", 45000.23, true),
				new Employee(1007, "Ramya", 98000.02, true),
				new Employee(1008, "Naveen", 10500.023, true));
		map.put("empList", list);
		return"show_report";
	}
}
