package com.beas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="Customer")
@Data
public class Customer {
	
	@Id
	@SequenceGenerator(name ="cu_seq",sequenceName = "CU_SEQ",allocationSize = 1)
	@GeneratedValue(generator = "cu_seq")
	@Column(name="id")
	private Integer cno;
	@Column(name ="name")
	private String cname;
	@Column(name="adderess")
	private String caddrs;
	@Column(name = "amount")
	private Double billAmount;
	
	
	
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", billAmount=" + billAmount + "]";
	}

	

}
