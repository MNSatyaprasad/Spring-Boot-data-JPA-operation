package com.beas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ActorServiceConsummerRunner4 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String Url = "http://localhost:8080/BootRest-Proj06-Provider-app/actor-api/register";
		String jsonData ="{\"id\":1001,\"name\":\"Rajesh\",\"age\":45,\"fee\":4000000.00,\"category\":\"Villan\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonData,headers);
		
		ResponseEntity<String> response = template.postForEntity(Url,entity , String.class);
		System.out.println("Response Body:: "+response.getBody());
		System.out.println("Response Status ::"+response.getStatusCode());

	}

}
