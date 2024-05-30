package com.bwas.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwas.entity.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "welcome";
	}
	@GetMapping("/register")
	public String showStudentRegistrationPage() {
		
		return "student_register";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map, @ModelAttribute("std") Student std) {

		System.out.println(std);
		System.out.println(std.hashCode());
		return "show_result";
	}

}
