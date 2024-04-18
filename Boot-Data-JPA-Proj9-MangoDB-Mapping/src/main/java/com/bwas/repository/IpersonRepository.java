package com.bwas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bwas.entity.Person;

public interface IpersonRepository extends MongoRepository<Person, String> {

}
