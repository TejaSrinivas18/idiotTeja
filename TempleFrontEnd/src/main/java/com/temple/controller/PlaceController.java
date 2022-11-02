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
import com.temple.model.Place;
import com.temple.service.PlaceService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	
	/*******************************************************************************************************
	 - Function Name	:	addPlace(@RequestBody Place place)
	 - Input Parameters	:	Place place
	 - Return Type		:	ResponseEntity<Place>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding place to database calls service method addPlace(place)
	 ********************************************************************************************************/
	@PostMapping("/addPlace")
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {
		Place place1 = placeService.addPlace(place);

		log.info("Place record added successfully");
		return new ResponseEntity<>(place1, HttpStatus.CREATED);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllPlaces()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Place>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllPlaces()
	 ********************************************************************************************************/
	@GetMapping("/retrievePlaces")
	public ResponseEntity<List<Place>> getAllPlaces() {
		List<Place> place = placeService.getAllPlaces();

		log.info("retrieved all Place records successfully");
		return new ResponseEntity<>(place, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getPlaceById(@PathVariable("placeId") Integer placeId)
	 - Input Parameters	:	Integer placeId
	 - Return Type		:	ResponseEntity<Place>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getPlaceById(placeId)
	 ********************************************************************************************************/
	@GetMapping("/retrievePlaceById/{placeId}")
	public ResponseEntity<Place> getPlaceById(@PathVariable("placeId") Integer placeId) {
		Place place = placeService.getPlaceById(placeId);

		log.info("retrieved Place record successfully");
		return new ResponseEntity<>(place, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deletePlace(@PathVariable("placeId") Integer placeId)
	 - Input Parameters	:	Integer placeId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method deletePlace(placeId)
	 ********************************************************************************************************/
	@DeleteMapping("/deletePlace/{placeId}")
	public ResponseEntity<HttpStatus> deletePlace(@PathVariable("placeId") Integer placeId) {
		placeService.deletePlace(placeId);

		log.info("Place record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updatePlace(@PathVariable("placeId") Integer placeId,@PathVariable("update") String update, @RequestBody Place place)
	 - Input Parameters	:	Integer placeId, String update, Place place
	 - Return Type		:	ResponseEntity<Place>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updateStreet(placeId, place),updateArea(placeId, place),updateCity(placeId, place),updateState(placeId, place),updatePincode(placeId, place)
	 ********************************************************************************************************/
	// update
	@PutMapping("/updatePlace/{placeId}/{update}")
	public ResponseEntity<Place> updatePlace(@PathVariable("placeId") Integer placeId,
			@PathVariable("update") String update, @RequestBody Place place) {

		if (update.equalsIgnoreCase("street")) {
			Place place1 = placeService.updateStreet(placeId, place);

			log.info("street updated successfully");
			return new ResponseEntity<>(place1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("area")) {
			Place place1 = placeService.updateArea(placeId, place);

			log.info("area updated successfully");
			return new ResponseEntity<>(place1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("city")) {
			Place place1  = placeService.updateCity(placeId, place);

			log.info("city updated successfully");
			return new ResponseEntity<>(place1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("state")) {
			Place place1  = placeService.updateState(placeId, place);

			log.info("state updated successfully");
			return new ResponseEntity<>(place1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("pincode")) {
			Place place1  = placeService.updatePincode(placeId, place);

			log.info("pincode updated successfully");
			return new ResponseEntity<>(place1, HttpStatus.OK);
		}
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
}
