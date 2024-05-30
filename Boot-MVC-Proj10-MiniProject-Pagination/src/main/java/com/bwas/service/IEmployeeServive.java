package com.bwas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bwas.model.Employee;

public interface IEmployeeServive {

	public Iterable<Employee> getAllEmployees();

	public String registerEmployee(Employee emp);

	public Employee getEmployeeByNo(int no);
	
	public String editEmployeeDetails(Employee emp);
	
	public String deleteEmployeeById(Integer eid);
	
	public Page<Employee> getAllByPagination(Pageable pageable);
}
