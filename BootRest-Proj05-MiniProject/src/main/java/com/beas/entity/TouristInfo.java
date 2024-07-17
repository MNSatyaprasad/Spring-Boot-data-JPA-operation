package com.beas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tourist_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TouristInfo {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "Toutist_seq", initialValue = 1952, allocationSize = 50)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.IDENTITY)
	private Integer tid;
	@Column(length = 55)
	@NonNull
	private String name;
	@Column(length = 100)
	@NonNull
	private String city;
	@NonNull
	@Column(length = 25)
	private String packageType;
	@NonNull
	private Double budget;

}
