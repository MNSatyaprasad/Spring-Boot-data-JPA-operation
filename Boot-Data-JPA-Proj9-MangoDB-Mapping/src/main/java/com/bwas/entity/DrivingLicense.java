package com.bwas.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "OTO_License_Details")
@Setter
@Getter
public class DrivingLicense {

	@Id
	private String id;
	private Long licenseNo;
	private LocalDate expieryDate;
	private Person person;

	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", licenseNo=" + licenseNo + ", expieryDate=" + expieryDate + "]";
	}

}
