package com.bwas.entity;

import lombok.Data;

@Data
public class Student {

	private Integer sid;
	private String sname;
	private String address ="hyd";
	private Double avg;
}