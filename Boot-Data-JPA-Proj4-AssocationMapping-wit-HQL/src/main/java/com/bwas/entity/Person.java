package com.bwas.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@RequiredArgsConstructor
public class Person implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "Per_Seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(length = 200)
	@NonNull
	private String pname;
	@NonNull
	@Column(length = 200)
	private String paddrs;
	//@NonNull
	@OneToMany(targetEntity = Phonenumber.class, cascade = CascadeType.ALL, mappedBy = "personInfo", fetch = FetchType.LAZY)
	// @JoinColumn(name="Person_id",referencedColumnName = "pid")
	private Set<Phonenumber> contactDetails;

	public Person() {
		System.out.println("Person.Person()");
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

	

}
