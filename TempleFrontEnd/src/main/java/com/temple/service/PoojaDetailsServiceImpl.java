package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.PoojaDetails;
import com.temple.repository.PoojaDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PoojaDetailsServiceImpl implements PoojaDetailsService{
	
	@Autowired
	private PoojaDetailsRepository poojaDetailsRepository;
	

	/*******************************************************************************************************
	 - Function Name	:	addPoojaDetails(PoojaDetails poojaDetails)
	 - Input Parameters	:	PoojaDetails poojaDetails
	 - Return Type		:	PoojaDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding PoojaDetails Record to the Database
	 ********************************************************************************************************/
	@Override
	public PoojaDetails addPoojaDetails(PoojaDetails poojaDetails) {
		return poojaDetailsRepository.save(poojaDetails);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllPoojaDetails()
	 - Input Parameters	:	
	 - Return Type		:	List<PoojaDetails>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All PoojaDetails Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<PoojaDetails> getAllPoojaDetails() {
		
		return poojaDetailsRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deletePoojaDetail(Integer poojaId)
	 - Input Parameters	:	Integer poojaId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting PoojaDetails Record from the Database based on poojaId
	 ********************************************************************************************************/
	@Override
	public void deletePoojaDetail(Integer poojaId) {
		
		if (!poojaDetailsRepository.existsById(poojaId)) {
			log.error("No poojaDetails found with id" + poojaId);
			throw new ResourceNotFoundException("No poojaDetails found with id" + poojaId);
		}
		
		poojaDetailsRepository.deleteById(poojaId);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updatePoojaType(Integer poojaId, PoojaDetails poojaDetails)
	 - Input Parameters	:	Integer poojaId, PoojaDetails poojaDetails
	 - Return Type		:	PoojaDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating PoojaType to the Database based on poojaId
	 ********************************************************************************************************/
	@Override
	public PoojaDetails updatePoojaType(Integer poojaId, PoojaDetails poojaDetails) {
		
		if (!poojaDetailsRepository.existsById(poojaId)) {
			log.error("No poojaDetails found with id" + poojaId);
			throw new ResourceNotFoundException("No poojaDetails found with id" + poojaId);
		}
		
		PoojaDetails poojaDetails1 = poojaDetailsRepository.findById(poojaId).orElseThrow(()-> new ResourceNotFoundException("Not found poojaDetails with poojaId " + poojaId));
		poojaDetails1.setPoojaType(poojaDetails.getPoojaType());
		return poojaDetailsRepository.save(poojaDetails1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updatePoojaPrice(Integer poojaId, PoojaDetails poojaDetails)
	 - Input Parameters	:	Integer poojaId, PoojaDetails poojaDetails
	 - Return Type		:	PoojaDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating PoojaPrice to the Database based on poojaId
	 ********************************************************************************************************/
	@Override
	public PoojaDetails updatePoojaPrice(Integer poojaId, PoojaDetails poojaDetails) {
		
		if (!poojaDetailsRepository.existsById(poojaId)) {
			log.error("No poojaDetails found with id" + poojaId);
			throw new ResourceNotFoundException("No poojaDetails found with id" + poojaId);
		}
		
		PoojaDetails poojaDetails1 = poojaDetailsRepository.findById(poojaId).orElseThrow(()-> new ResourceNotFoundException("Not found poojaDetails with poojaId " + poojaId));
		poojaDetails1.setPoojaPrice(poojaDetails.getPoojaPrice());
		return poojaDetailsRepository.save(poojaDetails1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getPoojaDetailsById(Integer poojaId)
	 - Input Parameters	:	Integer poojaId
	 - Return Type		:	PoojaDetails
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving PoojaDetails record from the Database based on poojaId
	 ********************************************************************************************************/
	@Override
	public PoojaDetails getPoojaDetailsById(Integer poojaId) {
		
		if (!poojaDetailsRepository.existsById(poojaId)) {
			log.error("No poojaDetails found with id" + poojaId);
			throw new ResourceNotFoundException("No poojaDetails found with id" + poojaId);
		}
		
		PoojaDetails poojaDetails = poojaDetailsRepository.findById(poojaId).orElseThrow(()-> new ResourceNotFoundException("Not found poojaDetails with poojaId " + poojaId));
		return poojaDetails;
		
	}

}
