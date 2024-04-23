package com.bwas.service;

import java.util.List;

import com.bwas.documnt.StockDetails;

public interface StockMgmtService {

	public String stockRegiste(StockDetails details);
	
	public String stockRegistartionBatch(List<StockDetails> list);
}
