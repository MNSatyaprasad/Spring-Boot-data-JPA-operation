package com.bwas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private Integer id;
	private String name;
	private Float avg;
	private LocalDateTime joiningDate;
	private String[] favcolors;
	private List<String> friends;
	private Set<Long> phone;
	private Map<String, Long> iddetails;
	private Address addrs;

}
