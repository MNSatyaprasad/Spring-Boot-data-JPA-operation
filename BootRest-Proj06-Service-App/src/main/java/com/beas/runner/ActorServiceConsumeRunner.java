package com.beas.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumeRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();

		String baseUrl = "http://localhost:8080/BootRest-Proj06-Provider-app/actor-api/wish";
		ResponseEntity<String> response = template.getForEntity(baseUrl, String.class);
		System.out.println("Response Entity::" + response.getBody());
		System.out.println("Response Status:: " + response.getStatusCode());

		// Get For in in RestTemplate
		String obj = template.getForObject(baseUrl, String.class);
		System.out.println("Result for Get For Object "+obj);
	}

}
