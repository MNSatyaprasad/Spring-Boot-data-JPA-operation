package com.beas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beas.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//@Query(value = "from Customer where billAmount >=?1 and billAmount<=?2")
	//public List<Customer> searchCustomerByBillAmount(double start,double end);
	
	/*
	 * @Query(value =
	 * "from com.beas.entity.Customer where billAmount >=?1 and billAmount<=?2")
	 * public List<Customer> searchCustomerByBillAmount(double start,double end);
	 */

	//@Query(value = "from Customer c where c.billAmount >=?1 and c.billAmount<=?2")
	//public List<Customer> searchCustomerByBillAmount(double start,double end);
	
	@Query(value = "select c from Customer c where c.billAmount >=?1 and c.billAmount<=?2")
	public List<Customer> searchCustomerByBillAmount(double start,double end);
	
	/*
	 * @Query(value =
	 * "select * from Customer c where c.billAmount >=:start and c.billAmount <=:end"
	 * ) public Object searchCustomerByBillAmount1(double start,double end);
	 */
	@Query(value = "select c.cno,c.billAmount from Customer c where c.cname =:name")
	public Object searchCustomerByName(String name);
	
	@Query(value = " select caddrs from Customer where cname =:name")
	public String searchByCity(String name);
	@Query(value = " select count(*),max(billAmount),min(billAmount),avg(billAmount),sum(billAmount) from Customer ")
	public Object searchAggerateFunctions();
	
	
}
