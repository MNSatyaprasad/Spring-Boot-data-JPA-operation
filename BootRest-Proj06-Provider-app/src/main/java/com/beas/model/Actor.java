package com.beas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
	
	private Integer id;
	private String name;
	private Integer age;
	private Double fee;
	private String category;

}
