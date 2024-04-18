package com.bwas.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bwasdocument.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {

}
