package com.bwas.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.service.IIOToMAssocationMapping;
@Component
public class OtoMAssocationMapping implements CommandLineRunner {

	@Autowired
	private IIOToMAssocationMapping service;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		List<Object[]> list = service.getAll();
		list.forEach(p ->{
			for(Object row : p) {
				System.out.print(row +" ");
			}
			System.out.println();
		});
	}

}