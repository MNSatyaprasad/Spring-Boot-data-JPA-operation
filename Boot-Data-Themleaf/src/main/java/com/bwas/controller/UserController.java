package com.bwas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bwas.entity.UserDetails;
import com.bwas.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveUser(@RequestBody UserDetails user) {
		String msg = userService.registerUser(user);
		return msg;
	}

	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public String update(@RequestBody UserDetails user) {
		 String msg = userService.updateUser(user);
		 return msg;
	}
	@GetMapping("/GET")
	public List<UserDetails> fetchAll(){
		return userService.getAllUser();
	}
}
