package com.bwas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.repo.IPersonRepository;

@Service
public class OtoMAssocationService implements IIOToMAssocationMapping {
	@Autowired
	private IPersonRepository personRepo;
	

	
	@Override
	public List<Object[]> getAll() {
		
		return personRepo.fetchTheDataUsingParent();
	}
	@Override
	public List<Object[]> getAllByCity(String city) {
		// TODO Auto-generated method stub
		return personRepo.fetchTheDataUsingByCity(city);
	}
}