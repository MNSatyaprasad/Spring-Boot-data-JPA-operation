package com.bwas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bwas.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

	//@Query(" select p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType from Person p inner join p.contactDetails ph ")
	//@Query("select p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p left join p.contactDetails ph ")
	//@Query("select p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p right join p.contactDetails ph ")
	@Query("select p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p full join p.contactDetails ph ")
	List<Object[]> fetchTheDataUsingParent();
	
	@Query("select p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType from Person p inner join p.contactDetails ph"
			+ " where p.paddrs =:city")
	List<Object[]> fetchTheDataUsingByCity(String city);
}
