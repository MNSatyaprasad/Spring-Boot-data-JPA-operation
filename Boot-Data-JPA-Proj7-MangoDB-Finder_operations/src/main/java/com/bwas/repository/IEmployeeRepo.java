package com.bwas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bwas.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {

	public List<Employee> findBySalaryBetween(Double start, Double end);

}
