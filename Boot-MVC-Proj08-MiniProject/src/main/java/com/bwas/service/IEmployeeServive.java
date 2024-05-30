package com.bwas.service;

import com.bwas.model.Employee;

public interface IEmployeeServive {

	public Iterable<Employee> getAllEmployees();

	public String registerEmployee(Employee emp);

	public Employee getEmployeeByNo(int no);
	
	public String editEmployeeDetails(Employee emp);
	
	public String deleteEmployeeById(Integer eid);
}
