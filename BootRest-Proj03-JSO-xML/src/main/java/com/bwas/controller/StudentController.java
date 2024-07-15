package com.bwas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwas.model.Student;

@RestController
@RequestMapping("/std")
public class StudentController {
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

}
