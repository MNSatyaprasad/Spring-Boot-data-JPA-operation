package com.bwas.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwas.entity.Student;

@Controller
public class SrudentRegisterController {
	@GetMapping("/")
	public String showHomePage() {
		
		return "welcome";
	}
	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("std")   Student std) {
		System.out.println("SrudentRegisterController.showRegistrationPage()");
		System.out.println("Model Class Objective "+std);
		return "student_register";
	}
	@PostMapping("/register")
	public String processStudent(Map<String, Object> map, @ModelAttribute("std") Student std) {
		
		System.out.println("SrudentRegisterController.processStudent()");
		System.out.println("Model Object Class  "+std);
		return "show_result";
	}
}
