package com.bwas.runner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.documnt.StockDetails;
import com.bwas.service.StockMgmtService;

@Component
public class StockDetailsRunner implements CommandLineRunner {
	@Autowired
	private StockMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * try { StockDetails s = new StockDetails(); s.setStockId(202478956);
		 * s.setStockName("HDFC Bank"); s.setStockPrice(850.32); s.setExchange("NSE");
		 * s.setTradingTime(LocalDateTime.now()); s.setIsListed(true); String str =
		 * service.stockRegiste(s); System.out.println(str); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		try {
			StockDetails s = new StockDetails(null, new Random().nextInt(1000), "TCS", 2504.23,"NSE" , LocalDateTime.now(), true);
			StockDetails s1 = new StockDetails(null, new Random().nextInt(1000), "INFOYS", 2390.13,"NSE" , LocalDateTime.now(), true);
			StockDetails s2 = new StockDetails(null, new Random().nextInt(1000), "TECHM", 504.23,"BSE" , LocalDateTime.now(), true);
		List<StockDetails> list = Arrays.asList(s,s1,s2);
			String str = service.stockRegistartionBatch(list);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
