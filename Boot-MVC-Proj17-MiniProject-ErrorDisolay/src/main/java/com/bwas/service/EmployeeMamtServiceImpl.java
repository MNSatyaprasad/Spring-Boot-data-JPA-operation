package com.bwas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.exception.EmployeeNotFoundException;
import com.bwas.model.Employee;
import com.bwas.repo.IemployeeRepository;

@Service
public class EmployeeMamtServiceImpl implements IEmployeeServive {
	@Autowired
	private IemployeeRepository repo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		int a =10/0;
		return repo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
	
		  int id = repo.save(emp).getEid();
		
		return "Employee is saved Sucessfully with ::  "+ id;
	}

	@Override
	public Employee getEmployeeByNo(int no) {
	     Employee  opt =  repo.findById(no).orElseThrow(() -> new EmployeeNotFoundException("Employee id was not found"));
	    return opt;
	
	}
	@Override
	public String editEmployeeDetails(Employee emp) {
		
		return "Employee Upadted With Employee id "+repo.save(emp).getEid();
	}
	
	@Override
	public String deleteEmployeeById(Integer eid) {
	
		  repo.deleteById(eid);
		return eid+"  Employee id Employee is deleted";
	}
}
