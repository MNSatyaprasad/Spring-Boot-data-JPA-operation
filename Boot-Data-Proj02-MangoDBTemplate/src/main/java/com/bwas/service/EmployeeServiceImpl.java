package com.bwas.service;

import java.util.List;
import java.util.concurrent.locks.Lock;

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

	@Override
	public List<Employee> showAllEmployesByEnameByOneChar(String chars) {

		return repo.getAllEmployesByEnameByOneChar(chars);
	}

	@Override
	public Integer fetchEmployeeCountBySalaryRange(Double start, Double end) {
		// TODO Auto-generated method stub
		return repo.getEmployeeCountBySalaryRange(start, end);
	}

	@Override
	public List<Employee> showAllEmployeeByEnameSorted() {
		// TODO Auto-generated method stub
		return repo.showAllEmployeeByEnameSorted();
	}
	@Override
	public int removeEmployeeswithNoAddrs() {
		// TODO Auto-generated method stub
		return repo.removeEmployeeswithNoAddrs();
	}
	@Override
	public Boolean doesEmployeesWorkingWithoutSalary() {
		// TODO Auto-generated method stub
		return repo.doesEmployeesWorkingWithoutSalary();
	}
	@Override
	public Boolean doesEmployeeWorkingWithSalaryRange(double satrtSalary, double endSalary) {
		// TODO Auto-generated method stub
		return repo.doesEmployeeWorkingWithSalaryRange(satrtSalary, endSalary);
	}
}
