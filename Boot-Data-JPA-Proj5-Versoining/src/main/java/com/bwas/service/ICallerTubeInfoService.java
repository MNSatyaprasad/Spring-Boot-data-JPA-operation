package com.bwas.service;

import com.bwas.entity.CallTunnerInfo;

public interface ICallerTubeInfoService {
	
	public String setCallerTune(CallTunnerInfo callTunnerInfo);

	public String updateTuneInfoById(Integer id,String tuneName,String movieName);
	
	public CallTunnerInfo showCallerTuneById(Integer id);
}
