package com.bwas.service;

import java.util.List;

import com.bwas.document.Employee;

public interface IEmployeeService {

	
	public List<Employee> searchByEmployeeInsalarayRange(Double start,Double end);
}
