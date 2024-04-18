package com.bwas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "OTO_Person_Info")
@Setter
@Getter
public class Person {

	@Id
	private String id;
	private String pname;
	private String paddrs;
	private DrivingLicense licenseDetails;

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

}
