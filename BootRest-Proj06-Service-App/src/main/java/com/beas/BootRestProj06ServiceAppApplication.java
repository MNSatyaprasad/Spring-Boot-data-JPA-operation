package com.beas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootRestProj06ServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestProj06ServiceAppApplication.class, args);
	}

	@Bean
	RestTemplate createTemplate() {
		return new RestTemplate();
	}
}
