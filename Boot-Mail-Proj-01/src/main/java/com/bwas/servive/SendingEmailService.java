package com.bwas.servive;

public interface SendingEmailService {
	
	public String purchaseItems(String[] items,Double[] prices,String[] toemails) throws Exception;

}
