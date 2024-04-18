package com.bwas.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Employee {
	@Id
	private String id;
	private Integer eno;
	private String ename;
	private String eaddrs;
	private Double salary;
	private Boolean isVaccinated;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", eno=" + eno + ", ename=" + ename + ", eaddrs=" + eaddrs + ", salary=" + salary
				+ ", isVaccinated=" + isVaccinated + "]";
	}

}
