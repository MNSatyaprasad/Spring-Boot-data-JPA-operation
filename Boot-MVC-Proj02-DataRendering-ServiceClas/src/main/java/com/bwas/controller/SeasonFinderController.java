package com.bwas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwas.service.SeasonFinderService;


@Controller
public class SeasonFinderController {
	@Autowired
	private SeasonFinderService service;
	@RequestMapping
	public String welcomeMsg() {
		return "welcome";
	}
	@RequestMapping("/display")
	public String showSeason(Map<String, Object> map) {
		String msg = service.findSeason();
		map.put("resultMsg", msg);
		return "season";
	}
	@RequestMapping("/report")
	public String reportMessage() {
		
		return "show_report";
	}
}
