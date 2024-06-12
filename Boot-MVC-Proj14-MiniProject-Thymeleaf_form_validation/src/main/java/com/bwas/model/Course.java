package com.bwas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="std_course")
@Data
public class Course {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "cur_seq_id",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double fee;
	private LocalDate startsDate;
	private String content;
}
