package com.bwas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bwas.entity.PlayerInfo;

public interface IPlayerInfoRepository extends MongoRepository<PlayerInfo, String> {

}
