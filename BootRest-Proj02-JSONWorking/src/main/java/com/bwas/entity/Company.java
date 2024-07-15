package com.bwas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	private Integer id;
	private String name;
	private String city;
	private Long pincode;

}
