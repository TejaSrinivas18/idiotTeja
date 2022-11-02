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
import com.temple.model.PoojaDetails;
import com.temple.service.PoojaDetailsService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class PoojaDetailsController {
	
	@Autowired
	private PoojaDetailsService poojaDetailsService;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addPoojaDetails(@RequestBody PoojaDetails poojaDetails)
	 - Input Parameters	:	PoojaDetails poojaDetails
	 - Return Type		:	ResponseEntity<PoojaDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding poojaDetails to database calls service method addPoojaDetails(poojaDetails)
	 ********************************************************************************************************/
	@PostMapping("/addPoojaDetails")
	public ResponseEntity<PoojaDetails> addPoojaDetails(@RequestBody PoojaDetails poojaDetails) {
		PoojaDetails pooja = poojaDetailsService.addPoojaDetails(poojaDetails);
		
		log.info("PoojaDetails record added successfully");
		return new ResponseEntity<>(pooja,HttpStatus.CREATED);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getAllPoojaDetails()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<PoojaDetails>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllPoojaDetails()
	 ********************************************************************************************************/
	@GetMapping("/retrievePoojaDetails")
	public ResponseEntity<List<PoojaDetails>> getAllPoojaDetails() {
		List<PoojaDetails> poojaDetails =poojaDetailsService.getAllPoojaDetails();
		
		log.info("retrieved all PoojaDetails records successfully");
		return new ResponseEntity<>(poojaDetails,HttpStatus.OK );
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getPoojaDetailsById(@PathVariable("poojaId") Integer poojaId)
	 - Input Parameters	:	Integer poojaId
	 - Return Type		:	ResponseEntity<PoojaDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getPoojaDetailsById(poojaId)
	 ********************************************************************************************************/
	@GetMapping("/retrievePoojaDetailsById/{poojaId}")
	public ResponseEntity<PoojaDetails> getPoojaDetailsById(@PathVariable("poojaId") Integer poojaId) {
		PoojaDetails poojaDetails =poojaDetailsService.getPoojaDetailsById(poojaId);
		
		log.info("retrieved PoojaDetails record successfully");
		return new ResponseEntity<>(poojaDetails,HttpStatus.OK );
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	deletePoojaDetail(@PathVariable("poojaId") Integer poojaId)
	 - Input Parameters	:	Integer poojaId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method deletePoojaDetail(poojaId)
	 ********************************************************************************************************/
	@DeleteMapping("/deletePoojaDetail/{poojaId}")
	public ResponseEntity<HttpStatus> deletePoojaDetail(@PathVariable("poojaId") Integer poojaId) {
		poojaDetailsService.deletePoojaDetail(poojaId);
		
		log.info("PoojaDetails record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	updatePoojaDetails(@PathVariable("poojaId") Integer poojaId,@PathVariable("update") String update, @RequestBody PoojaDetails poojaDetails)
	 - Input Parameters	:	Integer poojaId, String update, PoojaDetails poojaDetails
	 - Return Type		:	ResponseEntity<PoojaDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updatePoojaType(poojaId, poojaDetails),updatePoojaPrice(poojaId, poojaDetails), 
	 ********************************************************************************************************/
	// update
	@PutMapping("/updatePoojaDetails/{poojaId}/{update}")
	public ResponseEntity<PoojaDetails> updatePoojaDetails(@PathVariable("poojaId") Integer poojaId,
			@PathVariable("update") String update, @RequestBody PoojaDetails poojaDetails) {

		if (update.equalsIgnoreCase("PoojaType")) {
			PoojaDetails poojaDetails1 = poojaDetailsService.updatePoojaType(poojaId, poojaDetails);

			log.info("PoojaType updated successfully");
			return new ResponseEntity<>(poojaDetails1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("PoojaPrice")) {
			PoojaDetails poojaDetails1 = poojaDetailsService.updatePoojaPrice(poojaId, poojaDetails);

			log.info("PoojaPrice updated successfully");
			return new ResponseEntity<>(poojaDetails1, HttpStatus.OK);
		}
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
}
