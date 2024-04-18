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
	public List<Object[]> showEmployeeDetailsByAddrs(String addrs) {

		return repo.getempdataByAddrs(addrs);
	}

	@Override
	public List<Employee> fetchEmployeesByAddrs(String addrs) {

		return repo.getAllEmpByAddrs(addrs);
	}

	@Override
	public List<Employee> fetchEmpAllByAddrs(String addrs, String name) {

		return repo.getAllEmpByAddrsAndName(addrs, name);
	}

	@Override
	public List<Employee> showEmpAllDataBySalary(double satrtSalary, double endSalary) {

		return repo.getEmpAllDataBySalary(satrtSalary, endSalary);
	}
}
