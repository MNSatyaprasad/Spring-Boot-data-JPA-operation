package com.bwas.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@GetMapping("/report")
	public String showMessage1() {
		System.out.println("MyController.showMessage1()");
		return "welcome";
	}

	@PostMapping("/report")
	public String showMessage2() {
		System.out.println("MyController.showMessage2()");
		return "welcome";
	}

	@GetMapping("/data")
	public String sendData(Map<String, Object> map) {
		map.put("name", "raja");
		map.put("age", 25);
		return "show_report";
	}

	@GetMapping("/data1")
	public String sendDataArrays(Map<String, Object> map) {

		map.put("favColors", new String[] { "red", "green", "yellow", "green" });
		map.put("nickNames", List.of("chinni", "Banuu", "chota", "laoba"));
		map.put("phoneNumbers", Set.of(9999999, 777777.888888, 66666));
		map.put("idDetails", Map.of("adharNo", 78956423, "voterId", 789564230));
		return "show_report2";
	}
}
