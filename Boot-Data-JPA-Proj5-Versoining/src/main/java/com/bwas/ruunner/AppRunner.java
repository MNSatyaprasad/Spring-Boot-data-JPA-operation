package com.bwas.ruunner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.service.ICallerTubeInfoService;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private ICallerTubeInfoService service;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * CallTunnerInfo c = new CallTunnerInfo("Hello Guru Prema Kosam", "Magadeera");
		 * String msg = service.setCallerTune(c); System.out.println(msg);
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Id");
		Integer id = sc.nextInt();
		
	//CallTunnerInfo c =	service.showCallerTuneById(id);
	//System.out.println(c.toString());
	String msg = service.updateTuneInfoById(id, "Ekkdo putti Ekkodao perigi", "Student No 1");
	System.out.println(msg);

	}

}
