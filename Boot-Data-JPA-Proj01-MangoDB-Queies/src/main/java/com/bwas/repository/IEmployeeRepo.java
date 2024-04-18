package com.bwas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bwas.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {

	//@Query(fields ="{eno:1,eaddrs:1,salary:1}",value ="{eaddrs:?0}")
	@Query(fields = "{ename:1,eaddrs:1,salary:1}",value = "{eaddrs:?0}")
	public List<Object[]> getempdataByAddrs(String addrs);
	//@Query(value = "{eaddrs:?0}")
	@Query(fields = "{}",value = "{eaddrs:?0}")
	public List<Employee> getAllEmpByAddrs(String addrs);
	@Query(value = "{eaddrs:?0,ename:?1}")
	public List<Employee> getAllEmpByAddrsAndName(String addts,String name);
	@Query(value = "{salary:{$gte:?0},salary:{$lte:?1}}")
	public List<Employee> getEmpAllDataBySalary(double satrtSalary,double endSalary);
}
