package com.bwas.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderServiceImpl implements SeasonFinderService {

	@Override
	public String findSeason() {
		int month = LocalDate.now().getMonthValue();
		if (month <= 7 && month >= 9) {
			return "Rainy season";
		} else if (month >= 3 && month <= 6) {
			return "Summer season";
		} else {
			return "Winter season";
		}

	}

}
