package com.bwas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String hno;
	private String street;
	private String city;
	private Long pincode;
	
}
