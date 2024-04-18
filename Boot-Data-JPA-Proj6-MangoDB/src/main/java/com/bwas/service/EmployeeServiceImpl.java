package com.bwas.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String updateEmployeee(Employee employee) {
		Optional<Employee> opt = repo.findById(employee.getId());
		if (opt.isPresent()) {
			String idVal = repo.save(employee).getId();
			return idVal + "is upated Sucessfully";
		}
		return "No Value Is updated ";
	}

	@Override
	public String SaveAllEmployee(List<Employee> list) {
		List<Employee> emps = repo.saveAll(list);
		if (emps.size() > 0) {
			return emps.size() + "Savedd  Sucessfully";
		}
		return "No data Saved";
	}

	@Override
	public List<Employee> showAll() {

		return repo.findAll();
	}

	@Override
	public String deleteById(String idVal) {
		Optional<Employee> opt = repo.findById(idVal);
		if (opt.isPresent()) {
			repo.deleteById(idVal);
			return idVal + "Deleted Sucessfully";

		}
		return "No Id Found";
	}

	@Override
	public String saveIdValueusingUUUID(Employee employee) {
		String msg = repo.save(employee).getId();
		return msg + " Is saved Sucessfully";
	}
}
