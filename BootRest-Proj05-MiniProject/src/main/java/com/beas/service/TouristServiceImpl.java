package com.beas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beas.entity.TouristInfo;
import com.beas.exception.TouristNotFoundException;
import com.beas.repository.ITouristRepo;

@Service
public class TouristServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(TouristInfo tourist) {
		Integer id = touristRepo.save(tourist).getTid();
		return "Tourist is Registered having id Val::" + id;
	}

	@Override
	public List<TouristInfo> showAllTouristes() {
		List<TouristInfo> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public String updateTourist(TouristInfo tourist) {
		Optional<TouristInfo> opt = touristRepo.findById(tourist.getTid());
		if (opt.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid() + " Updated Sucessfully ";
		} else {
			throw new TouristNotFoundException(tourist.getTid() + " Tourist Not Found");
		}

	}

	@Override
	public String updateTouristById(Integer id, Double hikePercentage) {
		Optional<TouristInfo> opt = touristRepo.findById(id);
		if (opt.isPresent()) {
			TouristInfo touristInfo = opt.get();
			Double budget = touristInfo.getBudget();
			Double newBudget = budget + (budget * hikePercentage / 100.0);
			touristInfo.setBudget(newBudget);
			touristRepo.save(touristInfo);
			return id + " Budget Updated Sucessfully ";
		} else {
			throw new TouristNotFoundException(id + " Tourist Not found");
		}

	}

	@Override
	public String deleteById(Integer id) {
		Optional<TouristInfo> opt = touristRepo.findById(id);
		if (!opt.isPresent()) {
			throw new TouristNotFoundException("Tourist Id :" + id + " Not Found");
		} else {
			touristRepo.deleteById(id);
			return id + " Tourist is deleted Sucessfully";
		}
	}

	@Override
	public TouristInfo showTouristById(Integer id) {
		TouristInfo tourist = touristRepo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException(id + " id is not found"));
		return tourist;
	}
}
