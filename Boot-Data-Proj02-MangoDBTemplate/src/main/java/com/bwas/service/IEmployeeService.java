package com.bwas.service;

import java.util.List;

import com.bwas.document.Employee;

public interface IEmployeeService {

	public List<Object[]> showEmployeeDetailsByAddrs(String addrs);
	
	public List<Employee> fetchEmployeesByAddrs(String addrs);
	
	public List<Employee> fetchEmpAllByAddrs(String addrs,String name);
	
	public List<Employee> showEmpAllDataBySalary(double satrtSalary,double endSalary);
	
	public List<Employee> showAllEmployesByEnameByOneChar(String chars);
	
	public Integer fetchEmployeeCountBySalaryRange(Double start,Double end);
	
	public List<Employee> showAllEmployeeByEnameSorted();
	
	public int removeEmployeeswithNoAddrs();
	
	public Boolean doesEmployeesWorkingWithoutSalary();
	
	public Boolean doesEmployeeWorkingWithSalaryRange(double satrtSalary,double endSalary);

	
}
