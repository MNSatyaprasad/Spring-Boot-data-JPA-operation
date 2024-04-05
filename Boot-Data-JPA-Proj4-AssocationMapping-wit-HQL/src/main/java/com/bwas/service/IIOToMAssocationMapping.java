package com.bwas.service;

import java.util.List;

public interface IIOToMAssocationMapping {

	public List<Object[]> getAll();
	
	public List<Object[]> getAllByCity(String city);
}
