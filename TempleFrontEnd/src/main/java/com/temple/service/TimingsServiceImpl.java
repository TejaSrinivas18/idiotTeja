package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Timings;
import com.temple.repository.TimingsRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TimingsServiceImpl implements TimingsService{
	
	@Autowired
	private TimingsRepository timingsRepository; 

	
	/*******************************************************************************************************
	 - Function Name	:	addTimings(Timings timings)
	 - Input Parameters	:	Timings timings
	 - Return Type		:	Timings
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding Timings Record to the Database
	 ********************************************************************************************************/
	@Override
	public Timings addTimings(Timings timings) {
		return timingsRepository.save(timings);		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTimings()
	 - Input Parameters	:	
	 - Return Type		:	List<Timings>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All Timings Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<Timings> getAllTimings() {
		
		return timingsRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteTiming(Integer timingId)
	 - Input Parameters	:	Integer timingId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting Timings Record from the Database based on timingId
	 ********************************************************************************************************/
	@Override
	public void deleteTiming(Integer timingId) {
		
		if (!timingsRepository.existsById(timingId)) {
			log.error("No timings found with id" + timingId);
			throw new ResourceNotFoundException("No timings found with id" + timingId);
		}
		
		timingsRepository.deleteById(timingId);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateOpeningTime(Integer timingId, Timings timings)
	 - Input Parameters	:	Integer timingId, Timings timings
	 - Return Type		:	Timings
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating OpeningTime  to the Database based on timingId
	 ********************************************************************************************************/
	@Override
	public Timings updateOpeningTime(Integer timingId, Timings timings) {
		
		if (!timingsRepository.existsById(timingId)) {
			log.error("No timings found with id" + timingId);
			throw new ResourceNotFoundException("No timings found with id" + timingId);
		}
		
		Timings timings1 = timingsRepository.findById(timingId).orElseThrow(()-> new ResourceNotFoundException("Not found timings with timingId " + timingId));
		timings1.setOpeningTime(timings.getOpeningTime());
		return timingsRepository.save(timings1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateClosingTime(Integer timingId, Timings timings)
	 - Input Parameters	:	Integer timingId, Timings timings
	 - Return Type		:	Timings
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating ClosingTime to the Database based on timingId
	 ********************************************************************************************************/
	@Override
	public Timings updateClosingTime(Integer timingId, Timings timings) {
		
		if (!timingsRepository.existsById(timingId)) {
			log.error("No timings found with id" + timingId);
			throw new ResourceNotFoundException("No timings found with id" + timingId);
		}
		
		Timings timings1 = timingsRepository.findById(timingId).orElseThrow(()-> new ResourceNotFoundException("Not found timings with timingId " + timingId));
		timings1.setClosingTime(timings.getClosingTime());
		return timingsRepository.save(timings1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getTimingsById(Integer timingId)
	 - Input Parameters	:	Integer timingId
	 - Return Type		:	Timings
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Timings record from the Database based on timingId
	 ********************************************************************************************************/
	@Override
	public Timings getTimingsById(Integer timingId) {
		
		if (!timingsRepository.existsById(timingId)) {
			log.error("No timings found with id" + timingId);
			throw new ResourceNotFoundException("No timings found with id" + timingId);
		}
		
		Timings timings = timingsRepository.findById(timingId).orElseThrow(()-> new ResourceNotFoundException("Not found timings with timingId " + timingId));
		return timings;
	}

}
