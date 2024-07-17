package com.beas.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorConsumerRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String baseUrl = "http://localhost:8080/BootRest-Proj06-Provider-app/actor-api/report/{id}/{name}";
		// pass the values in arguments
		ResponseEntity<String> response = template.getForEntity(baseUrl, String.class, 101, "Satya");
		// pass the values using map
		Map<String, String> map = new HashMap<>();
		map.put("name", "Ramu");map.put("id", "100053");
		
		String result = template.getForObject(baseUrl, String.class,map );
		System.out.println("Result through get for values "+result);
		System.out.println("========================================");
		System.out.println("response Body :: " + response.getBody());
		System.out.println("Response Status code :: " + response.getStatusCodeValue());
		System.out.println("Response Headers " + response.getHeaders().toString());
	}

}
