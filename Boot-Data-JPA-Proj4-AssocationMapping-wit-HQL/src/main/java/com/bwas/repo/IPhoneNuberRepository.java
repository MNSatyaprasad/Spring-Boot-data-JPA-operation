package com.bwas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.entity.Phonenumber;

public interface IPhoneNuberRepository extends JpaRepository<Phonenumber, Integer> {

}
