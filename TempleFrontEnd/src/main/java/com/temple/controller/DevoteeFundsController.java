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
import com.temple.model.DevoteeFunds;
import com.temple.service.DevoteeFundsService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class DevoteeFundsController {
	
	@Autowired
	private DevoteeFundsService devoteeFundsService;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addDevoteeFunds(@RequestBody DevoteeFunds devoteeFunds)
	 - Input Parameters	:	DevoteeFunds devoteeFunds
	 - Return Type		:	ResponseEntity<DevoteeFunds>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding devoteeFunds to database calls service method addDevoteeFunds(devoteeFunds)
	 ********************************************************************************************************/
	@PostMapping("/addDevoteeFunds")
	public ResponseEntity<DevoteeFunds> addDevoteeFunds(@RequestBody DevoteeFunds devoteeFunds) {
		DevoteeFunds devotee = devoteeFundsService.addDevoteeFunds(devoteeFunds);
		
		log.info("Devotee record added successfully");
		return new ResponseEntity<>(devotee, HttpStatus.CREATED);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getAllDevotees()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<DevoteeFunds>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllDevotees()
	 ********************************************************************************************************/
	@GetMapping("/retrieveDevotees")
	public ResponseEntity<List<DevoteeFunds>> getAllDevotees() {
		List<DevoteeFunds> devotee =devoteeFundsService.getAllDevotees();
		
		log.info("retrieved all Devotee records successfully");
		return new ResponseEntity<>(devotee,HttpStatus.OK );
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getDevoteeById(@PathVariable("devoteeId") Integer devoteeId)
	 - Input Parameters	:	Integer devoteeId
	 - Return Type		:	ResponseEntity<DevoteeFunds>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getDevoteeById(devoteeId)
	 ********************************************************************************************************/
	@GetMapping("/retrieveDevoteeById/{devoteeId}")
	public ResponseEntity<DevoteeFunds> getDevoteeById(@PathVariable("devoteeId") Integer devoteeId) {
		DevoteeFunds devotee =devoteeFundsService.getDevoteeById(devoteeId);
		
		log.info("retrieved  Devotee record successfully");
		return new ResponseEntity<>(devotee,HttpStatus.OK );
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	deleteDevotee(@PathVariable("devoteeId") Integer devoteeId)
	 - Input Parameters	:	Integer devoteeId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting devoteeFunds from database based on devoteeId, calls service method deleteDevotee(devoteeId)
	 ********************************************************************************************************/
	@DeleteMapping("/deleteDevotee/{devoteeId}")
	public ResponseEntity<HttpStatus> deleteDevotee(@PathVariable("devoteeId") Integer devoteeId) {
		devoteeFundsService.deleteDevotee(devoteeId);
		
		log.info("Devotee record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	updateDevotee(@PathVariable("devoteeId") Integer devoteeId,@PathVariable("update") String update, @RequestBody DevoteeFunds devotee)
	 - Input Parameters	:	Integer devoteeId, String update, DevoteeFunds devotee
	 - Return Type		:	ResponseEntity<DevoteeFunds>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updateDevoteeName(devoteeId,devotee),updateDevoteeAmount(devoteeId,devotee),updateDevoteeMobileNumber(devoteeId,devotee),updateDevoteeEmail(devoteeId,devotee)
	 ********************************************************************************************************/
	// update 
	@PutMapping("/updateDevotee/{devoteeId}/{update}")
	public ResponseEntity<DevoteeFunds> updateDevotee(@PathVariable("devoteeId") Integer devoteeId,@PathVariable("update") String update, @RequestBody DevoteeFunds devotee){
		
		if(update.equalsIgnoreCase("DevoteeName")) {
			DevoteeFunds devotee1 = devoteeFundsService.updateDevoteeName(devoteeId,devotee);
		
		    log.info("DevoteeName updated successfully");
		    return new ResponseEntity<>(devotee1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("DevoteeAmount")) {
			DevoteeFunds devotee1= devoteeFundsService.updateDevoteeAmount(devoteeId,devotee);
			
		    log.info("DevoteeAmount updated successfully");
		    return new ResponseEntity<>(devotee1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("DevoteeMobileNumber")) {
			DevoteeFunds devotee1= devoteeFundsService.updateDevoteeMobileNumber(devoteeId,devotee);
			
		    log.info("DevoteeMobileNumber updated successfully");
		    return new ResponseEntity<>(devotee1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("DevoteeEmail")) {
			DevoteeFunds devotee1= devoteeFundsService.updateDevoteeEmail(devoteeId,devotee);
			
		    log.info("DevoteeEmail updated successfully");
		    return new ResponseEntity<>(devotee1, HttpStatus.OK);
		}
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
}
