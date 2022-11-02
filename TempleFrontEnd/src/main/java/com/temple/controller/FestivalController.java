package com.temple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Festival;
import com.temple.service.FestivalService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class FestivalController {

	@Autowired
	private FestivalService festivalService;

	
	/*******************************************************************************************************
	 - Function Name	:	addFestival(@RequestBody Festival festival)
	 - Input Parameters	:	Festival festival
	 - Return Type		:	ResponseEntity<Festival>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding festival to database calls service method addFestival(festival)
	 ********************************************************************************************************/
	@PostMapping("/addFestival")
	public ResponseEntity<Festival> addFestival(@RequestBody Festival festival) {
		Festival festival1 = festivalService.addFestival(festival);

		log.info("Festival record added successfully");
		return new ResponseEntity<>(festival1, HttpStatus.CREATED);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllFestivals()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Festival>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllFestivals()
	 ********************************************************************************************************/
	@GetMapping("/retrieveFestivals")
	public ResponseEntity<List<Festival>> getAllFestivals() {
		List<Festival> festival = festivalService.getAllFestivals();

		log.info("retrieved all Festival records successfully");
		return new ResponseEntity<>(festival, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getFestivalById(@PathVariable("festivalId") Integer festivalId)
	 - Input Parameters	:	Integer festivalId
	 - Return Type		:	ResponseEntity<Festival>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getFestivalById(festivalId)
	 ********************************************************************************************************/
	@GetMapping("/retrieveFestivalById/{festivalId}")
	public ResponseEntity<Festival> getFestivalById(@PathVariable("festivalId") Integer festivalId) {
		Festival festival = festivalService.getFestivalById(festivalId);

		log.info("retrieved Festival record successfully");
		return new ResponseEntity<>(festival, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteFestival(@PathVariable("festivalId") Integer festivalId)
	 - Input Parameters	:	Integer festivalId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting festival from database based on festivalId, calls service method getFestivalById(festivalId)
	 ********************************************************************************************************/
	@DeleteMapping("/deleteFestival/{festivalId}")
	public ResponseEntity<HttpStatus> deleteFestival(@PathVariable("festivalId") Integer festivalId) {
		festivalService.deleteFestival(festivalId);

		log.info("Festival record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateFestival(@PathVariable("festivalId") Integer festivalId,@PathVariable("update") String update, @RequestBody Festival festival)
	 - Input Parameters	:	Integer festivalId, String update, Festival festival
	 - Return Type		:	ResponseEntity<Festival>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:   calls service method updateFestivalName(festivalId, festival), updateFestivalDate(festivalId, festival), updateFestivalStartTime(festivalId, festival), updateFestivalEndTime(festivalId, festival)
	 ********************************************************************************************************/
	// update
	@PutMapping("/updateFestival/{festivalId}/{update}")
	public ResponseEntity<Festival> updateFestival(@PathVariable("festivalId") Integer festivalId,
			@PathVariable("update") String update, @RequestBody Festival festival) {

		if (update.equalsIgnoreCase("FestivalName")) {
			Festival festival1 = festivalService.updateFestivalName(festivalId, festival);

			log.info("FestivalName updated successfully");
			return new ResponseEntity<>(festival1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("FestivalDate")) {
			Festival festival1 = festivalService.updateFestivalDate(festivalId, festival);

			log.info("FestivalDate updated successfully");
			return new ResponseEntity<>(festival1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("FestivalStartTime")) {
			Festival festival1 = festivalService.updateFestivalStartTime(festivalId, festival);

			log.info("FestivalStartTime updated successfully");
			return new ResponseEntity<>(festival1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("FestivalEndTime")) {
			Festival festival1 = festivalService.updateFestivalEndTime(festivalId, festival);

			log.info("FestivalEndTime updated successfully");
			return new ResponseEntity<>(festival1, HttpStatus.OK);
		} 
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}

}
