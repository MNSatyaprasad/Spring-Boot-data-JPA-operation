package com.bwas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	/*
	 * @GetMapping("/report") public String reportData(@RequestParam Integer
	 * no, @RequestParam(required = false) String name) {
	 * 
	 * return no+"   "+name; }
	 */
	
	/*
	 * @GetMapping("/report/{no}/{name}") public String reportData(@PathVariable
	 * Integer no, @PathVariable String name) {
	 * 
	 * return no+"   "+name; }
	 */
	
	@GetMapping("/reports/{no}/{name}")
	public String fetchData(@PathVariable(required = false) Integer no, @PathVariable(required = false) String name) {	
		return no+"   "+name;
	}
	@GetMapping("/report/no/name")
	public ResponseEntity<String> showReport(@PathVariable(name = "no",required = false) Integer no,@PathVariable(required = false) String name ){
		
		return new ResponseEntity<String>("<h2> Repoet 1 </h2>",HttpStatus.OK);
	}
	@GetMapping("/report/{no}/name")
	public ResponseEntity<String> showReport2(@PathVariable(name = "no",required = false) Integer no,@PathVariable(required = false) String name ){
		
		return new ResponseEntity<String>("<h2> Repoet 2 </h2>",HttpStatus.OK);
	}
	@GetMapping("/report/no/{name}")
	public ResponseEntity<String> showReport3(@PathVariable(name = "no",required = false) Integer no,@PathVariable(required = false) String name ){
		
		return new ResponseEntity<String>("<h2> Repoet 3 </h2>",HttpStatus.OK);
	}
	@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport4(@PathVariable(name = "no",required = false) Integer no,@PathVariable(required = false) String name ){
		
		return new ResponseEntity<String>("<h2> Repoet 4  </h2>",HttpStatus.OK);
	}
	
	@GetMapping(value = {"/data/{no}/{name}","/data/{name}","/data/{no}","/data"})
	public ResponseEntity<String> showReport5(@PathVariable(name = "no",required = false) Integer no,@PathVariable(required = false) String name ){
		
		System.out.println(no+"   "+name);
		return new ResponseEntity<String>(no+"::  "+name,HttpStatus.OK);
	}
	
}
