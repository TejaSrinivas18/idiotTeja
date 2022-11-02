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
import com.temple.model.TicketDetails;
import com.temple.service.TicketDetailsService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class TicketDetailsController {

	@Autowired
	private TicketDetailsService ticketDetailsService;

	
	/*******************************************************************************************************
	 - Function Name	:	addTicketDetails(@RequestBody TicketDetails ticketDetails)
	 - Input Parameters	:	TicketDetails ticketDetails
	 - Return Type		:	ResponseEntity<TicketDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding TicketDetails to database calls service method addTicketDetails(ticketDetails)
	 ********************************************************************************************************/
	@PostMapping("/addTicketDetails")
	public ResponseEntity<TicketDetails> addTicketDetails(@RequestBody TicketDetails ticketDetails) {
		TicketDetails ticket = ticketDetailsService.addTicketDetails(ticketDetails);

		log.info("TicketDetails record added successfully");
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTicketDetails()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<TicketDetails>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:   calls service method getAllTicketDetails()
	 ********************************************************************************************************/
	// retrieve tickets
	@GetMapping("/retrieveTicketDetails")
	public ResponseEntity<List<TicketDetails>> getAllTicketDetails() {
		List<TicketDetails> ticket = ticketDetailsService.getAllTicketDetails();

		log.info("retrieved all TicketDetails records successfully");
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getTicketDetailsById(@PathVariable("ticketId") Integer ticketId)
	 - Input Parameters	:	Integer ticketId
	 - Return Type		:	ResponseEntity<TicketDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:   calls service method getTicketDetailsById(ticketId)
	 ********************************************************************************************************/
	@GetMapping("/retrieveTicketDetailsById/{ticketId}")
	public ResponseEntity<TicketDetails> getTicketDetailsById(@PathVariable("ticketId") Integer ticketId) {
		TicketDetails ticket = ticketDetailsService.getTicketDetailsById(ticketId);

		log.info("retrieved TicketDetails record successfully");
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteTicket(@PathVariable("ticketId") Integer ticketId)
	 - Input Parameters	:	Integer ticketId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:   calls service method deleteTicket(ticketId)
	 ********************************************************************************************************/
	// deleteById
	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketDetailsService.deleteTicket(ticketId);

		log.info("TicketDetails record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateTicketDetails(@PathVariable("ticketId") Integer ticketId,@PathVariable("update") String update, @RequestBody TicketDetails ticketDetails)
	 - Input Parameters	:	Integer ticketId,String update,TicketDetails ticketDetails
	 - Return Type		:	ResponseEntity<TicketDetails>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:   calls service method updateTicketType(ticketId, ticketDetails),updateTicketPrice(ticketId, ticketDetails)
	 ********************************************************************************************************/
	// update
	@PutMapping("/updateTicketDetails/{ticketId}/{update}")
	public ResponseEntity<TicketDetails> updateTicketDetails(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("update") String update, @RequestBody TicketDetails ticketDetails) {

		if (update.equalsIgnoreCase("TicketType")) {
			TicketDetails ticketDetails1 = ticketDetailsService.updateTicketType(ticketId, ticketDetails);

			log.info("TicketType updated successfully");
			return new ResponseEntity<>(ticketDetails1, HttpStatus.OK);
		} 
		else if (update.equalsIgnoreCase("TicketPrice")) {
			TicketDetails ticketDetails1 = ticketDetailsService.updateTicketPrice(ticketId, ticketDetails);

			log.info("TicketPrice updated successfully");
			return new ResponseEntity<>(ticketDetails1, HttpStatus.OK);
		}
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}

}
