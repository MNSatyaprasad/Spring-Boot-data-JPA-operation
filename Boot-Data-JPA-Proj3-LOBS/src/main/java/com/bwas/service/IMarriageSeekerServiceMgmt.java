package com.bwas.service;

import java.util.Optional;

import com.bwas.entity.MarriageSeeker;

public interface IMarriageSeekerServiceMgmt {

	public String registerMarriageSeeker(MarriageSeeker marriageSeeker);
	
	public Optional<MarriageSeeker> searchSeekerById(Integer id);
	
	public Optional<MarriageSeeker> searchSeekerByName(String name);
	
}
