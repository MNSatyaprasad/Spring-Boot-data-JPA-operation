package com.bwas.service;

import java.util.List;

import com.bwas.entity.UserDetails;

public interface IUserService {

	public String registerUser(UserDetails user);
	
	public String updateUser(UserDetails user);
	
	public List<UserDetails> getAllUser();
}
