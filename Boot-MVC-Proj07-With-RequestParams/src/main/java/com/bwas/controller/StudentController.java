package com.bwas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cg;

	@GetMapping("/data")
	public String params(@RequestParam("sno") int no, @RequestParam("sname") String name) {

		System.out.println(no + "   " + name);
		return "show_result";
	}

	@GetMapping("/dataofparams")
	public String params1(@RequestParam int no, @RequestParam String name) {

		System.out.println(no + "  " + name);
		return "show_result";
	}

	@GetMapping("/dataforsingleparam")
	public String parms3(@RequestParam int no, @RequestParam(required = false) String name) {
		System.out.println(no + "  " + name);
		return "show_result";
	}

	@GetMapping("/dataofdefaultvalue")
	public String params4(@RequestParam int no, @RequestParam(defaultValue = "EEE") String name) {
		System.out.println(no + "  " + name);
		return "show_result";
	}
	@GetMapping("/getData")
	public String showdata(HttpSession se, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println(" Web App Name ::" +sc.getContextPath());
		System.out.println(" DS logical  name ::"+ cg.getServletName());
		System.out.println("  Session id "+se.getId());
		System.out.println("Current Req Uri::"+ req.getRequestURI());
		System.out.println(" Response Context Type "+res.getContentType());
    return "welcome";		
	}
}
