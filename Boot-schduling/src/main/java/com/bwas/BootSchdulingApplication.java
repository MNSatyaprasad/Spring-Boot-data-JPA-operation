package com.bwas;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchdulingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BootSchdulingApplication.class, args);
		System.out.println("Application Start time  "+new Date());
	}

}
