package com.bwas.service;

public interface IIOToMAssocationMapping {

	public void saveDataUsingParesnt();
	
	public void saveDataUsingChild();
	
	public void loadDataUsingParent();
	
	public void loadDataUsingChild();
	
	public String deleteByPerson(Integer pid);
	
	public String deleteAllPhoneNumberOfPerson(Integer personId);
	
	public void addingNewChildExstingParent(int id);
	
	
}
