package com.bwas.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bwas.entity.Customer;

@Controller
public class CustomerController {
	
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	@GetMapping("/register")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust,Map<String, Object> map) {
		
		return "customer_register";
		
	}
}
