package com.bwas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.PlayerInfo;
import com.bwas.repository.IPlayerInfoRepository;

@Service
public class PlayerInfoServiceImpl implements IplayerInfoService {
	@Autowired
	private IPlayerInfoRepository repo;
	
	@Override
	public String savePlayerInfo(PlayerInfo info) {
		String idVal = repo.save(info).getId();
		return idVal+"   :: Inserted SucessFully ";
	}

	
}
