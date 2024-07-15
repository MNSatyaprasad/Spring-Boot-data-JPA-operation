package com.bwas.controller;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WishMessageController {
	@GetMapping("/message")
	public ResponseEntity<String> showMessage(){
		
		System.out.println("WishMessageController.showMessage()");
		
		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		String msg = null;
		if(hour<3) {
			msg ="Good Moring";
		}else if(hour<12) {
			msg ="Good Afternoon";
		}else if(hour <16)
			msg = "Good Evening";
		else 
			msg ="Good Night";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
