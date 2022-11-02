package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Festival;
import com.temple.repository.FestivalRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FestivalServiceImpl implements FestivalService{
	
	@Autowired
	private FestivalRepository festivalRepository;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addFestival(Festival festival)
	 - Input Parameters	:	Festival festival
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding Festival Record to the Database
	 ********************************************************************************************************/
	@Override
	public Festival addFestival(Festival festival) {
		return festivalRepository.save(festival);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllFestivals()
	 - Input Parameters	:	
	 - Return Type		:	List<Festival>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All Festival Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<Festival> getAllFestivals() {
	
		return festivalRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteFestival(Integer festivalId)
	 - Input Parameters	:	Integer festivalId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting Festival Record from the Database based on festivalId
	 ********************************************************************************************************/
	@Override
	public void deleteFestival(Integer festivalId) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		festivalRepository.deleteById(festivalId);
		
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	updateFestivalName(Integer festivalId, Festival festival)
	 - Input Parameters	:	Integer festivalId, Festival festival
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating FestivalName to the Database based on festivalId
	 ********************************************************************************************************/
	//UPDATE
	@Override
	public Festival updateFestivalName(Integer festivalId, Festival festival) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		Festival festival1 = festivalRepository.findById(festivalId).orElseThrow(()-> new ResourceNotFoundException("Not found festival with festivalId " + festivalId));
		festival1.setFestivalName(festival.getFestivalName());
		return festivalRepository.save(festival1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateFestivalDate(Integer festivalId, Festival festival)
	 - Input Parameters	:	Integer festivalId, Festival festival
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating FestivalDate to the Database based on festivalId
	 ********************************************************************************************************/
	@Override
	public Festival updateFestivalDate(Integer festivalId, Festival festival) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		Festival festival1 = festivalRepository.findById(festivalId).orElseThrow(()-> new ResourceNotFoundException("Not found festival with festivalId " + festivalId));
		festival1.setFestivalDate(festival.getFestivalDate());
		return festivalRepository.save(festival1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateFestivalStartTime(Integer festivalId, Festival festival)
	 - Input Parameters	:	Integer festivalId, Festival festival
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating FestivalStartTime to the Database based on festivalId
	 ********************************************************************************************************/
	@Override
	public Festival updateFestivalStartTime(Integer festivalId, Festival festival) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		Festival festival1 = festivalRepository.findById(festivalId).orElseThrow(()-> new ResourceNotFoundException("Not found festival with festivalId " + festivalId));
		festival1.setFestivalStartTime(festival.getFestivalStartTime());
		return festivalRepository.save(festival1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateFestivalEndTime(Integer festivalId, Festival festival)
	 - Input Parameters	:	Integer festivalId, Festival festival
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating FestivalEndTime to the Database based on festivalId
	 ********************************************************************************************************/
	@Override
	public Festival updateFestivalEndTime(Integer festivalId, Festival festival) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		Festival festival1 = festivalRepository.findById(festivalId).orElseThrow(()-> new ResourceNotFoundException("Not found festival with festivalId " + festivalId));
		festival1.setFestivalEndTime(festival.getFestivalEndTime());
		return festivalRepository.save(festival1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getFestivalById(Integer festivalId)
	 - Input Parameters	:	Integer festivalId
	 - Return Type		:	Festival
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Festival record from the Database based on festivalId
	 ********************************************************************************************************/
	@Override
	public Festival getFestivalById(Integer festivalId) {
		
		if (!festivalRepository.existsById(festivalId)) {
            log.error("No festival found with id" + festivalId);
			throw new ResourceNotFoundException("No festival found with id" + festivalId);
		}
		
		Festival festival = festivalRepository.findById(festivalId).orElseThrow(()-> new ResourceNotFoundException("Not found festival with festivalId " + festivalId));
		return festival;
	}
	

}



