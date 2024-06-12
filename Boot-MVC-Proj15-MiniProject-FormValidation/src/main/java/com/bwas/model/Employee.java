package com.bwas.model;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="emp")
@Data
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_id_seq", initialValue = 10001,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer eid;
	@Column(length = 20)
	private String name;
	@Column(length = 15)
	private String job;
	@Column(length = 15)
	private String dept;
	@Column(length = 450)
	private String addrs;
	private Double salary;
}
