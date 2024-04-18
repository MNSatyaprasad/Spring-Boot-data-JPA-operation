package com.bwas.service;

import java.util.List;

import com.bwas.document.Employee;

public interface IEmployeeService {

	public List<Object[]> showEmployeeDetailsByAddrs(String addrs);
	
	public List<Employee> fetchEmployeesByAddrs(String addrs);
	
	public List<Employee> fetchEmpAllByAddrs(String addrs,String name);
	
	public List<Employee> showEmpAllDataBySalary(double satrtSalary,double endSalary);
	
}
