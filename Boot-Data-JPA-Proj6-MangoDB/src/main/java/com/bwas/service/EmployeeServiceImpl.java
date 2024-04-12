package com.bwas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.repository.IEmployeeRepo;
import com.bwasdocument.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public String saveEmployee(Employee employee) {
		Integer id = repo.save(employee).getEno();

		return "Employee is saved wit id no: " + id;
	}
}
