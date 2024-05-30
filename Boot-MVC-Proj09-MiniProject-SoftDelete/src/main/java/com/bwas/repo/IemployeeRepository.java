package com.bwas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.model.Employee;

public interface IemployeeRepository extends JpaRepository<Employee, Integer> {

}
