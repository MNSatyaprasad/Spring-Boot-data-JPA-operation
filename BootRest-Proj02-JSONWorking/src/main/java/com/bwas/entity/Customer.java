package com.bwas.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@NonNull
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private Float billAmount;
	private String[] favColors;
	private Set<Long> phone;
	private List<String> friends;
	private Map<String, Long> idvalues;
	private Company company;
	
	

}
