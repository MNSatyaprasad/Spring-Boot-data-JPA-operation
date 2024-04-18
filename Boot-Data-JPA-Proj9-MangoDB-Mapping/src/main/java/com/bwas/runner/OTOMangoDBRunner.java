package com.bwas.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.entity.DrivingLicense;
import com.bwas.entity.Person;
import com.bwas.service.IRTOMgmtService;

@Component
public class OTOMangoDBRunner implements CommandLineRunner {

	@Autowired
	private IRTOMgmtService irtoMgmtService;

	@Override
	public void run(String... args) throws Exception {

		
		/*
		 * Person p = new Person(); p.setPname("Satya"); p.setPaddrs("Kolkata");
		 * DrivingLicense license = new DrivingLicense();
		 * license.setLicenseNo(456789456l); license.setExpieryDate(LocalDate.of(2024,
		 * 10, 29)); p.setLicenseDetails(license); String msg =
		 * irtoMgmtService.registerPersonWithDrivingLicense(p); System.out.println(msg);
		 * 
		 * DrivingLicense child = new DrivingLicense(); child.setLicenseNo(789456123l);
		 * child.setExpieryDate(LocalDate.of(2024, 04, 21)); Person p1= new Person();
		 * p.setPname("Rahul"); p.setPaddrs("HariDwar"); child.setPerson(p1);
		 * 
		 * String msg1= irtoMgmtService.registerLicenseDetailsWithPerson(child);
		 * System.out.println(msg1);
		 */
		irtoMgmtService.fetchLicebseWithPerson().forEach(per ->{
			System.out.println(per);
			Person p = per.getPerson();
			System.out.println("parest ::" + p);
		});
		System.out.println("========================");
		irtoMgmtService.fetchPersonWithChild().forEach(p -> {
			System.out.println("Parent ::"+ p);
			DrivingLicense l = p.getLicenseDetails();
			System.out.println(l.getId() + "  "+l.getLicenseNo() +"  "+ l.getExpieryDate());
		});
	}
}
