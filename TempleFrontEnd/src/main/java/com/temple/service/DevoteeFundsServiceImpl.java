package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.DevoteeFunds;
import com.temple.repository.DevoteeFundsRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DevoteeFundsServiceImpl implements DevoteeFundsService{
	
	@Autowired
	private DevoteeFundsRepository devoteeFundsRepository;

	
	/*******************************************************************************************************
	 - Function Name	:	addDevoteeFunds(DevoteeFunds devoteeFunds)
	 - Input Parameters	:	DevoteeFunds devoteeFunds
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding DevoteeFunds Record to the Database
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds addDevoteeFunds(DevoteeFunds devoteeFunds) {
		return devoteeFundsRepository.save(devoteeFunds);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllDevotees()
	 - Input Parameters	:	
	 - Return Type		:	List<DevoteeFunds>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All DevoteeFunds Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<DevoteeFunds> getAllDevotees() {
		
		return devoteeFundsRepository.findAll();
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	deleteDevotee(Integer devoteeId)
	 - Input Parameters	:	Integer devoteeId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting DevoteeFunds Record from the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public void deleteDevotee(Integer devoteeId) {
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		devoteeFundsRepository.deleteById(devoteeId);	
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateDevoteeName(Integer devoteeId, DevoteeFunds devotee)
	 - Input Parameters	:	Integer devoteeId, DevoteeFunds devotee
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating DevoteeName to the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds updateDevoteeName(Integer devoteeId, DevoteeFunds devotee) {
		
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		DevoteeFunds devotee1 = devoteeFundsRepository.findById(devoteeId).orElseThrow(()-> new ResourceNotFoundException("Not found devotee with devoteeId " + devoteeId));
		devotee1.setDevoteeName(devotee.getDevoteeName());
		return devoteeFundsRepository.save(devotee1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateDevoteeAmount(Integer devoteeId, DevoteeFunds devotee)
	 - Input Parameters	:	Integer devoteeId, DevoteeFunds devotee
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating DevoteeAmount to the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds updateDevoteeAmount(Integer devoteeId, DevoteeFunds devotee) {
		
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		DevoteeFunds devotee1 = devoteeFundsRepository.findById(devoteeId).orElseThrow(()-> new ResourceNotFoundException("Not found devotee with devoteeId " + devoteeId));
		devotee1.setDevoteeAmount(devotee.getDevoteeAmount());
		return devoteeFundsRepository.save(devotee1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateDevoteeMobileNumber(Integer devoteeId, DevoteeFunds devotee)
	 - Input Parameters	:	Integer devoteeId, DevoteeFunds devotee
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating DevoteeMobileNumber to the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds updateDevoteeMobileNumber(Integer devoteeId, DevoteeFunds devotee) {
		
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		DevoteeFunds devotee1 = devoteeFundsRepository.findById(devoteeId).orElseThrow(()-> new ResourceNotFoundException("Not found devotee with devoteeId " + devoteeId));
		devotee1.setDevoteeMobileNumber(devotee.getDevoteeMobileNumber());
		return devoteeFundsRepository.save(devotee1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getDevoteeById(Integer devoteeId)
	 - Input Parameters	:	Integer devoteeId
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving DevoteeFunds record from the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds getDevoteeById(Integer devoteeId) {
		
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		DevoteeFunds devoteeFunds= devoteeFundsRepository.findById(devoteeId).orElseThrow(()-> new ResourceNotFoundException("Not found Devotee with id " + devoteeId));
		return devoteeFunds;
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateDevoteeEmail(Integer devoteeId, DevoteeFunds devotee)
	 - Input Parameters	:	Integer devoteeId, DevoteeFunds devotee
	 - Return Type		:	DevoteeFunds
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating DevoteeEmail to the Database based on devoteeId
	 ********************************************************************************************************/
	@Override
	public DevoteeFunds updateDevoteeEmail(Integer devoteeId, DevoteeFunds devotee) {
		
		if (!devoteeFundsRepository.existsById(devoteeId)) {
			log.error("No devotee found with id" + devoteeId);
			throw new ResourceNotFoundException("No devotee found with id" + devoteeId);
		}
		
		DevoteeFunds devotee1 = devoteeFundsRepository.findById(devoteeId).orElseThrow(()-> new ResourceNotFoundException("Not found devotee with devoteeId " + devoteeId));
		devotee1.setDevoteeEmail(devotee.getDevoteeEmail());
		return devoteeFundsRepository.save(devotee1);
		
	}

}
