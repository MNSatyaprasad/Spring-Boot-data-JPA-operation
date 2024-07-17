package com.beas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beas.entity.TouristInfo;

public interface ITouristRepo extends JpaRepository<TouristInfo, Integer> {

}
