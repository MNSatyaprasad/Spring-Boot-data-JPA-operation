package com.bwas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.DrivingLicense;
import com.bwas.entity.Person;
import com.bwas.repository.IDrivingLicense;
import com.bwas.repository.IpersonRepository;

@Service
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	@Autowired
	private IpersonRepository personRepository;

	@Autowired
	private IDrivingLicense drivingLicenserepo;

	@Override
	public String registerPersonWithDrivingLicense(Person person) {

		return "Person With Driving License Saved with id " + personRepository.save(person).getId();
	}

	@Override
	public String registerLicenseDetailsWithPerson(DrivingLicense license) {

		return "License Details are saved through the Driving License"+drivingLicenserepo.save(license);
	}
	
	@Override
	public List<DrivingLicense> fetchLicebseWithPerson() {
		// TODO Auto-generated method stub
		return drivingLicenserepo.findAll() ;
	}
	@Override
	public List<Person> fetchPersonWithChild() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
}
