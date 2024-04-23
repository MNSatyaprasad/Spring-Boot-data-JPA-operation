package com.bwas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.bwas.documnt.StockDetails;

@Service
public class StockMgmtserviceImpl implements StockMgmtService {
	@Autowired
	private MongoTemplate template;
	
	@Override
	public String stockRegiste(StockDetails details) {
		//int idVal = template.save(details,"stock").getStockId();
		//int idVal = template.save(details).getStockId();
		int idVal = template.insert(details).getStockId();
		return "Document is saved with "+idVal;
	}
	@Override
	public String stockRegistartionBatch(List<StockDetails> list) {
		int size = ((List<StockDetails>) template.insertAll(list)).size();
		return size +"  Documents Are saved Sucessfully";
	}
}
