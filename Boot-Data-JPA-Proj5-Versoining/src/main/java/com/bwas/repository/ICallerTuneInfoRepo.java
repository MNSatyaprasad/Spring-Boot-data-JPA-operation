package com.bwas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.entity.CallTunnerInfo;

public interface ICallerTuneInfoRepo extends JpaRepository<CallTunnerInfo, Integer> {

}
