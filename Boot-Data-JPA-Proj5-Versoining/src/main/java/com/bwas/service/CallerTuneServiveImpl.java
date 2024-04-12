package com.bwas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.CallTunnerInfo;
import com.bwas.repository.ICallerTuneInfoRepo;

@Service
public class CallerTuneServiveImpl implements ICallerTubeInfoService {

	@Autowired
	private ICallerTuneInfoRepo repo;

	@Override
	public String setCallerTune(CallTunnerInfo callTunnerInfo) {
		Integer id = repo.save(callTunnerInfo).getTuneId();
		return "Saved SuccessFully With Id = " + id;
	}

	@Override
	public String updateTuneInfoById(Integer id, String tuneName, String movieName) {

		CallTunnerInfo info = repo.getReferenceById(id);

		if (info != null) {

			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallTunnerInfo ci = repo.save(info);
			return "Object Update Count " + ci.getUpdateCount() + " Tunes Lastly Modified On" + ci.getLastlyUpdatedOn()
					+ " Created on " + ci.getServiceOptedOn();
		} else {
			return "Caller Tune Servive is not  found";
		}

	}

	@Override
	public CallTunnerInfo showCallerTuneById(Integer id) {

		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Caller Tune is not found"));
	}
}
