package com.bwas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.servive.SendingEmailService;

@Component
public class EmaiSendingRunner implements CommandLineRunner {
	@Autowired
	private SendingEmailService emailService;

	@Override
	public void run(String... args) throws Exception {

		String[] items = { "laptop", "mobile", "water Bottle" };
		Double[] prices = { 55000.00, 25250.32, 99.99 };

		String[] toMais = { "nagasatyaprasad.m@gmail.com", "satya.prasad@beas.co.in", 
				"satyaprasad.mn@gmail.com" };
		String msg = emailService.purchaseItems(items, prices, toMais);
		System.out.println(msg);
	}

}
