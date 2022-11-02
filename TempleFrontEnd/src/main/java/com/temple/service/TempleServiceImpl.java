package com.temple.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Temple;
import com.temple.repository.TempleRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TempleServiceImpl implements TempleService{
	//Logger log = LoggerFactory.getLogger(TempleServiceImpl.class);
	
	@Autowired
	private TempleRepository templeRepository;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addTemple(Temple temple)
	 - Input Parameters	:	Temple temple
	 - Return Type		:	Temple
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding Temple Record to the Database
	 ********************************************************************************************************/
	@Override
	public Temple addTemple(Temple temple) {
		 Temple temple1 = templeRepository.save(temple);
		 
		 return temple1;
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getAllTemples()
	 - Input Parameters	:	
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Retrieving All Temple Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<Temple> getAllTemples() {
		
		List<Temple> temples = templeRepository.findAll();
		return temples;
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	deleteTemple(Integer templeId)
	 - Input Parameters	:	Integer templeId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Deleting Temple Record from the Database based on templeId
	 ********************************************************************************************************/
	@Override
	public void deleteTemple(Integer templeId) {
		
		if (!templeRepository.existsById(templeId)) {
			log.error("No temple found with id" + templeId);
			throw new ResourceNotFoundException("No temple found with id" + templeId);
		}
		
		templeRepository.deleteById(templeId);
		//templeRepository.find
		
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleById(Integer templeId)
	 - Input Parameters	:	Integer templeId
	 - Return Type		:	Temple
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Retrieving Temple Record from the Database based on templeId
	 ********************************************************************************************************/
	@Override
	public Temple retrieveTempleById(Integer templeId) {
		
		Temple temple1 = templeRepository.findById(templeId).orElseThrow(() ->  
		new ResourceNotFoundException("No Temple found with id = " + templeId));
		
		return temple1;
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleByName(String templeName)
	 - Input Parameters	:	String templeName
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Retrieving Temple Records from the Database based on templeName
	 ********************************************************************************************************/
	@Override
	public List<Temple> retrieveTempleByName(String templeName) {
		
		if (!templeRepository.existsByTempleName(templeName)) {
			log.error("No temple found with templeName" + templeName);
			throw new ResourceNotFoundException("No temple found with templeName" + templeName);
		}
		
		List<Temple> temple1 = templeRepository.findByTempleName(templeName);
		return temple1;
	}
	
    
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemple()
	 - Input Parameters	:	
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Retrieving All Temple Records from the Database
	 ********************************************************************************************************/
	// PDF Generator
	@Override
	public List<Temple> retrieveTemple() {
		List<Temple> list = templeRepository.findAll();
		return list;
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	updateTempleName(int templeId, Temple temple)
	 - Input Parameters	:	int templeId, Temple temple
	 - Return Type		:	Temple
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating TempleName to the Database based on templeId
	 ********************************************************************************************************/
	@Override
	public Temple updateTempleName(int templeId, Temple temple) {
		
		if (!templeRepository.existsById(templeId)) {
			log.error("No temple found with templeId" + templeId);
			throw new ResourceNotFoundException("No temple found with templeId" + templeId);
		}
		
		Temple temple1 = templeRepository.findById(templeId).orElseThrow(()-> new ResourceNotFoundException("Not found temple with templeId " + templeId));
		temple1.setTempleName(temple.getTempleName());
		return templeRepository.save(temple1);
	
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	updateTempleHistory(int templeId, Temple temple)
	 - Input Parameters	:	int templeId, Temple temple
	 - Return Type		:	Temple
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating TempleHistory to the Database based on templeId
	 ********************************************************************************************************/
	@Override
	public Temple updateTempleHistory(int templeId, Temple temple) {
		
		if (!templeRepository.existsById(templeId)) {
			log.error("No temple found with templeId" + templeId);
			throw new ResourceNotFoundException("No temple found with templeId" + templeId);
		}
		
		Temple temple1 = templeRepository.findById(templeId).orElseThrow(()-> new ResourceNotFoundException("Not found temple with templeId " + templeId));
		temple1.setTempleHistory(temple.getTempleHistory());
		return templeRepository.save(temple1);
		
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByCity(String city)
	 - Input Parameters	:	String city
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Temple Records from the Database based on city
	 ********************************************************************************************************/
	@Override
	public List<Temple> retrieveTemplesByCity(String city) {
		
//		if (!templeRepository.existsByCity(city)) {
//			log.error("No temple found with city" + city);
//			throw new ResourceNotFoundException("No temple found with city" + city);
//		}
		
		List<Temple> temple = templeRepository.findByCity(city);
		return temple;
	}
	
    
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByArea(String area)
	 - Input Parameters	:	String area
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Temple Records from the Database based on area
	 ********************************************************************************************************/
	@Override
	public List<Temple> retrieveTemplesByArea(String area) {
		
//		if (!templeRepository.existsByArea(area)) {
//			log.error("No temple found with area" + area);
//			throw new ResourceNotFoundException("No temple found with area" + area);
//		}
		
		List<Temple> temple = templeRepository.findByArea(area);
		return temple;
	}
	
    
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByState(String state)
	 - Input Parameters	:	String state
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Temple Records from the Database based on state
	 ********************************************************************************************************/
	@Override
	public List<Temple> retrieveTemplesByState(String state) {
		
//		if (!templeRepository.existsByState(state)) {
//			log.error("No temple found with state" + state);
//			throw new ResourceNotFoundException("No temple found with state" + state);
//		}
		
		List<Temple> temple = templeRepository.findByState(state);
		return temple;
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByLocation(String state, String city, String area)
	 - Input Parameters	:	String state, String city, String area
	 - Return Type		:	List<Temple>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Temple Records from the Database based on state,city,area
	 ********************************************************************************************************/
	@Override
	public List<Temple> retrieveTemplesByLocation(String state, String city, String area) {
		
//		if (!templeRepository.existsByStateAndCityAndArea(state,city,area)) {
//			log.error("No temple found with stateAndCityAndArea " + state +" "+ city+" " + area);
//			throw new ResourceNotFoundException("No temple found with stateAndCityAndArea " + state +" "+ city+" " + area);
//		}
		
		List<Temple> temple = templeRepository.findByStateAndCityAndArea(state,city,area);
		return temple;
	}

}
