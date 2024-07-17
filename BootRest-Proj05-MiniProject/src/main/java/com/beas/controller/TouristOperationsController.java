package com.beas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.beas.entity.TouristInfo;
import com.beas.service.ITouristMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tourist")
@Tag(name = "Tourist",description = "Tourist operations Controller")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService touristMgmtService;
	@Operation(summary = "Save the Tourist Info",description = "Persist tourist info")
	@ApiResponses(value = {
	                       @ApiResponse(responseCode = "201",description = "Tourist Saved",
	                       content =  {@Content(mediaType = "application/json",
	                       schema = @Schema(implementation = TouristInfo.class))})})
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody TouristInfo tourist) {
		try {
			String msg = touristMgmtService.registerTourist(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findall")
	public ResponseEntity<Object> fetchAllTourists() {
		try {
			List<TouristInfo> list = touristMgmtService.showAllTouristes();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Object> fetchTouristById(@PathVariable("id") Integer id) {
		try {
			TouristInfo info = touristMgmtService.showTouristById(id);
			return new ResponseEntity<Object>(info, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateTourist(@RequestBody TouristInfo touristInfo) {
		try {
			String msg = touristMgmtService.updateTourist(touristInfo);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/modify/{id}/{hike}")
	public ResponseEntity<String> updaeTouristDetailsById(@PathVariable("id") Integer id,
			@PathVariable("hike") Double percentage) {
		try {
			String msg = touristMgmtService.updateTouristById(id, percentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		try {
			String msg = touristMgmtService.deleteById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
