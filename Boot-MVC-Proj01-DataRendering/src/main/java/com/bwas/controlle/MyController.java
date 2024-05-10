package com.bwas.controlle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@RequestMapping("/")
	public String welcomMsg() {
		System.out.println("MyController.welcomMsg()");
		return "welcome";
	}

	/*
	 * @RequestMapping("/process") public String process(Map<String, Object> map) {
	 * 
	 * map.put("attr1", "Attribute1"); map.put("attr2", new Date()); return
	 * "process"; }
	 */
	@RequestMapping("/process")
	public String process(Model model) {
		model.addAttribute("attr1", "Name");
		model.addAttribute("attr2", LocalDateTime.now());

		return "forward:report";
	}

	@RequestMapping("/processmap")
	public String process1(Model model) {
		model.addAttribute("attr1", "Name");
		model.addAttribute("attr2", LocalDateTime.now());

		return "show_data";
	}
	//@RequestMapping("/report")
	public Model report() {
		Model model = new BindingAwareModelMap();
		model.addAttribute("name","NataRaz");
		model.addAttribute("date",LocalDateTime.now());
		return model;
	}
	//@RequestMapping("/report1")
	public Map<String, Object> report1(){
		 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Rahul Choduary  ");
		map.put("date", LocalDateTime.now());
		return map;
	}
	//@RequestMapping("/report3")
	public ModelAndView report3() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","Satya Prasad");
		mav.addObject("date",new Date());
		
		mav.setViewName("report");
		return mav;
	}
	@RequestMapping("/report1")
	public void process3(Map<String, Object> map) {
		map.put("name", "ramya");
		map.put("date", LocalDate.now());
	}
	@RequestMapping("/report")
	public String process4(Model model) {
		model.addAttribute("name","Bharat singh");
		model.addAttribute("date",LocalDateTime.now());
		return null;
	}
	@RequestMapping("/redircet")
	public String processs(HttpServletRequest req) {
		System.out.println("MyController.processs()");
		req.setAttribute("attr1", "Val1");
		return "redirect:processmap";
	}
}
