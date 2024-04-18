package com.bwas.service;

import java.util.List;

import com.bwasdocument.Employee;

public interface IEmployeeService {

	public String saveEmployee(Employee employee);
	
	public String SaveAllEmployee(List<Employee> list);
	
	public String updateEmployeee(Employee employee);
	
	public List<Employee> showAll();
	
	public String deleteById(String idVal);
	
	public String saveIdValueusingUUUID(Employee employee);
}
