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
import com.temple.model.Timings;
import com.temple.service.TimingsService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class TimingsController {

	@Autowired
	private TimingsService timingsService;

	
	/*******************************************************************************************************
	 - Function Name	:	addTimings(@RequestBody Timings timings)
	 - Input Parameters	:	Timings timings
	 - Return Type		:	ResponseEntity<Timings>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding Timings to database calls service method addTimings(timings)
	 ********************************************************************************************************/
	@PostMapping("/addTimings")
	public ResponseEntity<Timings> addTimings(@RequestBody Timings timings) {
		Timings timing = timingsService.addTimings(timings);

		log.info("Timings record added successfully");
		return new ResponseEntity<>(timing, HttpStatus.CREATED);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTimings()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Timings>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTimings()
	 ********************************************************************************************************/
	// retrieve timings
	@GetMapping("/retrieveTimings")
	public ResponseEntity<List<Timings>> getAllTimings() {
		List<Timings> timings = timingsService.getAllTimings();

		log.info("retrieved all Timings records successfully");
		return new ResponseEntity<>(timings, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getTimingsById(@PathVariable("timingId") Integer timingId)
	 - Input Parameters	:	Integer timingId
	 - Return Type		:	ResponseEntity<Timings>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getTimingsById(timingId)
	 ********************************************************************************************************/
	@GetMapping("/retrieveTimingsById/{timingId}")
	public ResponseEntity<Timings> getTimingsById(@PathVariable("timingId") Integer timingId) {
		Timings timings = timingsService.getTimingsById(timingId);

		log.info("retrieved Timings record successfully");
		return new ResponseEntity<>(timings, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteTiming(@PathVariable("timingId") Integer timingId)
	 - Input Parameters	:	Integer timingId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method deleteTiming(timingId)
	 ********************************************************************************************************/
	// deleteById
	@DeleteMapping("/deleteTiming/{timingId}")
	public ResponseEntity<HttpStatus> deleteTiming(@PathVariable("timingId") Integer timingId) {
		timingsService.deleteTiming(timingId);

		log.info("Timings record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateTimings(@PathVariable("timingId") Integer timingId,@PathVariable("update") String update, @RequestBody Timings timings)
	 - Input Parameters	:	Integer timingId,String update,Timings timings
	 - Return Type		:	ResponseEntity<Timings>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updateOpeningTime(timingId, timings),updateClosingTime(timingId, timings)
	 ********************************************************************************************************/
	// update
	@PutMapping("/updateTimings/{timingId}/{update}")
	public ResponseEntity<Timings> updateTimings(@PathVariable("timingId") Integer timingId,
			@PathVariable("update") String update, @RequestBody Timings timings) {

		if (update.equalsIgnoreCase("openingTime")) {
			Timings timings1 = timingsService.updateOpeningTime(timingId, timings);

			log.info("openingTime updated successfully");
			return new ResponseEntity<>(timings1, HttpStatus.OK);
		} 
		else if (update.equalsIgnoreCase("closingTime")) {
			Timings  timings1= timingsService.updateClosingTime(timingId, timings);

			log.info("closingTime updated successfully");
			return new ResponseEntity<>(timings1, HttpStatus.OK);
		} 
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}

}
