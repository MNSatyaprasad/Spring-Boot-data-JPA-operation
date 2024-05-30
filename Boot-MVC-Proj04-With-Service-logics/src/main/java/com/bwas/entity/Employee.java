package com.bwas.entity;

import lombok.Data;

public class Employee {

	private Integer eNo;
	private String eName;
	private Double empSlary;
	private Boolean isVanccinated;

	public Integer geteNo() {
		return eNo;
	}

	public void seteNo(Integer eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Double getEmpSlary() {
		return empSlary;
	}

	public void setEmpSlary(Double empSlary) {
		this.empSlary = empSlary;
	}

	public Boolean getIsVanccinated() {
		return isVanccinated;
	}

	public void setIsVanccinated(Boolean isVanccinated) {
		this.isVanccinated = isVanccinated;
	}

	public Employee(Integer eNo, String eName, Double empSlary, Boolean isVanccinated) {
		super();
		this.eNo = eNo;
		this.eName = eName;
		this.empSlary = empSlary;
		this.isVanccinated = isVanccinated;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
