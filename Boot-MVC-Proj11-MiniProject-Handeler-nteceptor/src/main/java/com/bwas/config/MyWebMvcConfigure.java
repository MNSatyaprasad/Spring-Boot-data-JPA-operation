package com.bwas.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class MyWebMvcConfigure implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyWebMvcConfigure.addInterceptors()");
		registry.addInterceptor( new TimeCheckInteceptot());
	}

}
