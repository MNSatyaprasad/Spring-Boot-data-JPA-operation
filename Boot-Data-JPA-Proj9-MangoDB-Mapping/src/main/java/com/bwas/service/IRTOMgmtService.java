package com.bwas.service;

import java.util.List;

import com.bwas.entity.DrivingLicense;
import com.bwas.entity.Person;

public interface IRTOMgmtService {
	
	public String registerPersonWithDrivingLicense(Person person);
	
	public String registerLicenseDetailsWithPerson(DrivingLicense license);
	
	public List<Person> fetchPersonWithChild();
	
	public List<DrivingLicense> fetchLicebseWithPerson();

}
