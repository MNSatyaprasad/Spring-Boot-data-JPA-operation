package com.beas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsummerRunner3 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String Url = "http://localhost:8080/BootRest-Proj06-Provider-app/actor-api/repport1";
		ResponseEntity<String> response = template.getForEntity(Url, String.class);
		System.out.println(response.getBody());

	}

}
