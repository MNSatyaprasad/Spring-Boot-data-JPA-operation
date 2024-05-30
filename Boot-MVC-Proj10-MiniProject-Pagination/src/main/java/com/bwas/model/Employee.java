package com.bwas.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@SuppressWarnings("deprecation")
@Entity
@Table(name="emp")
@SQLDelete(sql = "update emp set aective ='No' where eid=?")
//@Where(clause = "aective <> 'No'")
@SQLRestriction("aective <> 'No'")
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
	private String aective="yes";
}
