package com.bwas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.MarriageSeeker;
import com.bwas.repository.IMarriageSeekarRepo;
@Service
public class MarriageSeekerServiceImpl implements IMarriageSeekerServiceMgmt {
	
	@Autowired
	private IMarriageSeekarRepo repo;
	

	@Override
	public String registerMarriageSeeker(MarriageSeeker marriageSeeker) {
	Integer id =   repo.save(marriageSeeker).getId();
		return "Marriage Seeker info is saved with id value "+id;
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Integer id) {

		 Optional<MarriageSeeker> opt = repo.findById(id);
		
		return opt;
	}
	@Override
	public Optional<MarriageSeeker> searchSeekerByName(String name) {
		
		return repo.findByName(name);
	}
}
