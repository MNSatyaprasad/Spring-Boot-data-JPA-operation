package com.bwas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.UserDetails;
import com.bwas.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public String registerUser(UserDetails user) {
		UserDetails regUser =repository.save(user);
		return regUser.getId()+" Saved Successfully";
	}
	
	@Override
	public String updateUser(UserDetails user) {
		
		Optional<UserDetails> ud = repository.findById(user.getId());
		if(ud.isPresent()) {
			repository.save(user);
			return user.getId()+" Updated Successfully";
		}
		
		return null;
	}
	@Override
	public List<UserDetails> getAllUser() {
	
		return repository.findAll();
	}
}
