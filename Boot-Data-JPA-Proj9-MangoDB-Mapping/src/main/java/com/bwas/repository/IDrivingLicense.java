package com.bwas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bwas.entity.DrivingLicense;

public interface IDrivingLicense extends MongoRepository<DrivingLicense, String> {

}
