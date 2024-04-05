package com.beas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer aid;
	@NonNull
	private String city;
	
}
