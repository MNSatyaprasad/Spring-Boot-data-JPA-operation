package com.bwas;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj12MiniProjectI18NApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj12MiniProjectI18NApplication.class, args);
	}
	@Bean(name = "localeResolver")
	public SessionLocaleResolver createSlResolver() {
		SessionLocaleResolver resolver= new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	@Bean
	public LocaleChangeInterceptor createLCInteceptor() {
		LocaleChangeInterceptor inteceptor = new LocaleChangeInterceptor();
		inteceptor.setParamName("lang"); //default is Locale
		return inteceptor;
	}
}
