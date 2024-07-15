package com.bwas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwas.entity.Company;
import com.bwas.entity.Customer;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showReport() {

		Customer c = new Customer(01, "Rahul", 5000.3f);
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);

	}

	@GetMapping("/report2")
	public ResponseEntity<Customer> showRepotes() {

		Customer c = new Customer();
		c.setId(1002);
		c.setName("Satya");
		c.setBillAmount(5000.63f);
		c.setFavColors(new String[] { "Red", "Orange", "Green" });
		c.setPhone(Set.of(2222222l, 555555555l, 5555555l, 99999999l));
		c.setFriends(List.of("Rahul", "Ram", "Rama", "Raj"));
		c.setIdvalues(Map.of("Adhar", 123456l, "voter", 5654236l, "Pan Number", 87895456l));

		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}

	@GetMapping(value = "/report3")
	public ResponseEntity<Customer> showReport2() {
		Customer c = new Customer();
		c.setId(80002);
		c.setName("Prasad");
		c.setBillAmount(8999.23f);
		c.setFavColors(new String[] { "blue", "greay", "red" });
		c.setFriends(List.of("ttt", "kkkk", "llll", "oooo"));
		c.setPhone(Set.of(22222222l, 555555555555l, 5555555l, 54444445l));
		c.setIdvalues(Map.of("Adhar", 123456l, "voter", 5654236l, "Pan Number", 87895456l));
		c.setCompany(new Company(2000, "Infoysys", "Kolkata", 55555l));
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	@GetMapping("/report4")
	public ResponseEntity<List<Customer>> showReport3() {

		Customer c1 = new Customer(1001, "Prasad", 15000.2f);
		Customer c2 = new Customer(1002, "Ram", 35000.2f);
		Customer c3 = new Customer(1003, "Raj", 25000.2f);
		Customer c4 = new Customer(1004, "Ajay", 45000.2f);
		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
