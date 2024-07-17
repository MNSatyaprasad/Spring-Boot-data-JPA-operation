package com.beas.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TouristConsummerRunner implements CommandLineRunner {

	private String baseUrl = "http://localhost:8080/BootRest-Proj05-MiniProject/tourist";

	@Override
	public void run(String... args) throws Exception {
		String post = baseUrl + "/register";
		String jsonData = "{ \"name\":\"Raj\", \"city\":\"Manali\", \"packageType\":\"1D_1N\",\"budget\":500.23}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<String>(jsonData, headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.postForEntity(post, request, String.class);

		System.out.println("Response Body ::" + response.getBody());
		System.out.println("Response Code :: " + response.getStatusCode());

		System.out.println("++++++++++++++++++");

		String getall = baseUrl + "/findall";

		ResponseEntity<String> response1 = template.getForEntity(getall, String.class);
		System.out.println("Response Body ::" + response1.getBody());
		System.out.println("Response Code :: " + response1.getStatusCode());

		System.out.println("++++++++++++++++++");

		String put = baseUrl + "/modify";

		String putJsonData = "{\"tid\":2053, \"name\":\"AbhiShek\", \"city\":\"Ayodhya\", \"packageType\":\"1D_1N\",\"budget\":500.23}";

		HttpHeaders headers2 = new HttpHeaders();

		headers2.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request1 = new HttpEntity<String>(putJsonData, headers2);
		template.put(put, request1);
		System.out.println("Updated Sucessfully");

		System.out.println("========================");

		//String patch = baseUrl + "/modify/{id}/{hike}";
		//HttpHeaders headers3 = new HttpHeaders();
		
		//HttpEntity<String> request2 = new HttpEntity<String>(headers3);

		//String result = template.patchForObject(patch, request2, String.class, Map.of("id",2053,"hike",200.23));
		//System.out.println("Patch Update results "+result);
		
		String delete = baseUrl+"/delete/{id}";
		
		template.delete(delete,2057);
		
	}

}
