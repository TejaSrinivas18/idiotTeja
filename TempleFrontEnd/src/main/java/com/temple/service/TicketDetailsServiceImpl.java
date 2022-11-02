package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.TicketDetails;
import com.temple.repository.TicketDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TicketDetailsServiceImpl implements TicketDetailsService{
	
	@Autowired
	private TicketDetailsRepository ticketDetailsRepository;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addTicketDetails(TicketDetails ticketDetails)
	 - Input Parameters	:	TicketDetails ticketDetails
	 - Return Type		:	TicketDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding TicketDetails Record to the Database
	 ********************************************************************************************************/
	@Override
	public TicketDetails addTicketDetails(TicketDetails ticketDetails) {
		return ticketDetailsRepository.save(ticketDetails);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTicketDetails()
	 - Input Parameters	:	
	 - Return Type		:	List<TicketDetails>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All TicketDetails Records from the Database 
	 ********************************************************************************************************/
	@Override
	public List<TicketDetails> getAllTicketDetails() {
		
		return ticketDetailsRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteTicket(Integer ticketId)
	 - Input Parameters	:	Integer ticketId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting TicketDetails Record from the Database based on the ticketId
	 ********************************************************************************************************/
	@Override
	public void deleteTicket(Integer ticketId) {
		
		if (!ticketDetailsRepository.existsById(ticketId)) {
			log.error("No ticketDetails found with id" + ticketId);
			throw new ResourceNotFoundException("No ticketDetails found with id" + ticketId);
		}
		
		ticketDetailsRepository.deleteById(ticketId);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateTicketType(Integer ticketId, TicketDetails ticketDetails)
	 - Input Parameters	:	Integer ticketId, TicketDetails ticketDetails
	 - Return Type		:	TicketDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating TicketType to the Database based on the ticketId
	 ********************************************************************************************************/
	@Override
	public TicketDetails updateTicketType(Integer ticketId, TicketDetails ticketDetails) {
		
		if (!ticketDetailsRepository.existsById(ticketId)) {
			log.error("No ticketDetails found with id" + ticketId);
			throw new ResourceNotFoundException("No ticketDetails found with id" + ticketId);
		}
		
		TicketDetails ticketDetails1 = ticketDetailsRepository.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Not found ticketDetails with ticketId " + ticketId));
		ticketDetails1.setTicketType(ticketDetails.getTicketType());
		return ticketDetailsRepository.save(ticketDetails1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateTicketPrice(Integer ticketId, TicketDetails ticketDetails)
	 - Input Parameters	:	Integer ticketId, TicketDetails ticketDetails
	 - Return Type		:	TicketDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating TicketPrice to the Database based on the ticketId
	 ********************************************************************************************************/
	@Override
	public TicketDetails updateTicketPrice(Integer ticketId, TicketDetails ticketDetails) {
		
		if (!ticketDetailsRepository.existsById(ticketId)) {
			log.error("No ticketDetails found with id" + ticketId);
			throw new ResourceNotFoundException("No ticketDetails found with id" + ticketId);
		}
		
		TicketDetails ticketDetails1 = ticketDetailsRepository.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Not found ticketDetails with ticketId " + ticketId));
		ticketDetails1.setTicketPrice(ticketDetails.getTicketPrice());
		return ticketDetailsRepository.save(ticketDetails1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getTicketDetailsById(Integer ticketId)
	 - Input Parameters	:	Integer ticketId
	 - Return Type		:	TicketDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving TicketDetails record from the Database based on the ticketId
	 ********************************************************************************************************/
	@Override
	public TicketDetails getTicketDetailsById(Integer ticketId) {
		
		if (!ticketDetailsRepository.existsById(ticketId)) {
			log.error("No ticketDetails found with id" + ticketId);
			throw new ResourceNotFoundException("No ticketDetails found with id" + ticketId);
		}
		
		TicketDetails ticketDetails = ticketDetailsRepository.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Not found ticketDetails with ticketId " + ticketId));
		return ticketDetails;
	}

}