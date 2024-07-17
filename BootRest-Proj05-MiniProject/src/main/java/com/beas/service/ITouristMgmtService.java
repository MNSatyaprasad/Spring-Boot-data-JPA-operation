package com.beas.service;

import java.util.List;

import com.beas.entity.TouristInfo;

public interface ITouristMgmtService {

	public String registerTourist(TouristInfo tourist);
	
	public List<TouristInfo> showAllTouristes();
	
	public String updateTourist(TouristInfo tourist);
	
	public String updateTouristById(Integer id,Double hikePercentage);
	
	public String deleteById(Integer id);
	
	public TouristInfo showTouristById(Integer id);
}
