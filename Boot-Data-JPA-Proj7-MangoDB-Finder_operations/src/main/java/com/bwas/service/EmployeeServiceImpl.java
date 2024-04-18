package com.bwas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.document.Employee;
import com.bwas.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepo repo;

	
	@Override
	public List<Employee> searchByEmployeeInsalarayRange(Double start, Double end) {
	
		return repo.findBySalaryBetween(start, end);
	}
}
