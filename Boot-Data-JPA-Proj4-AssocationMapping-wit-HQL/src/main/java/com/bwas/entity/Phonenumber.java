package com.bwas.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Phonenumber implements Serializable {

	@Id
	@SequenceGenerator(name = "gen2", sequenceName = "PN_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.IDENTITY)
	private Integer regNo;
	@NonNull
	private Long mobileNo;
	@NonNull
	private String provider;
	@NonNull
	private String numberType;
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Person_id", referencedColumnName = "pid")
	private Person personInfo;

	public Phonenumber() {
		System.out.println("PhoneNumber.PhoneNumber()");
	}

	@Override
	public String toString() {
		return "Phonenumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", provider=" + provider + ", numberType="
				+ numberType + "]";
	}

}
