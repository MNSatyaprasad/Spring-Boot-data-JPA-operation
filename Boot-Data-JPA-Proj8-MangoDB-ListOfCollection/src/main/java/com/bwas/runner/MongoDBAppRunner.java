package com.bwas.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.entity.PlayerInfo;
import com.bwas.service.IplayerInfoService;

@Component
public class MongoDBAppRunner implements CommandLineRunner {
	@Autowired
	private IplayerInfoService infoService;

	@Override
	public void run(String... args) throws Exception {
		List<String> nickNames = List.of("Talava", "MS", "helicaptorPlyer", "Best captian");
		Set<Integer> phoneNumbers = Set.of(99999999, 8888888, 77777777, 6666666, 55555555);
		Map<String, Object> bestKnocks = Map.of("Asia cup", "60 runs", "2011 T20 WorldCup", "Best finsher");
		Properties props = new Properties();
		props.put("Adhar", "123456789012");
		props.put("Voter Id", "UID35456987");
		PlayerInfo info = new PlayerInfo();
		info.setPlayerName("M S Dhoni");
		info.setPaddrs("Rnchi");
		info.setNickNames(nickNames);
		info.setJerseyNo(18);
		info.setIdDetails(props);
		info.setImpKoncks(bestKnocks);
		info.setContactNumbers(phoneNumbers);

		String msg = infoService.savePlayerInfo(info);
		System.out.println(msg);
	}

}
