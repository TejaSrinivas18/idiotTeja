package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Place;
import com.temple.repository.PlaceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceRepository placeRepository;
	
	/*******************************************************************************************************
	 - Function Name	:	addPlace(Place place)
	 - Input Parameters	:	Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding Place Record to the Database
	 ********************************************************************************************************/
	@Override
	public Place addPlace(Place place) {
		return placeRepository.save(place);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllPlaces()
	 - Input Parameters	:	
	 - Return Type		:	List<Place>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All Place Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<Place> getAllPlaces() {
		
		return placeRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deletePlace(Integer placeId)
	 - Input Parameters	:	Integer placeId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting Place Record from the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public void deletePlace(Integer placeId) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		placeRepository.deleteById(placeId);		
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	updateStreet(Integer placeId, Place place)
	 - Input Parameters	:	Integer placeId, Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating street to the Database based on placeId
	 ********************************************************************************************************/
	//UPDATE
	@Override
	public Place updateStreet(Integer placeId, Place place) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place1 = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		place1.setStreet(place.getStreet());
		return placeRepository.save(place1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateArea(Integer placeId, Place place)
	 - Input Parameters	:	Integer placeId, Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating area to the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public Place updateArea(Integer placeId, Place place) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place1 = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		place1.setArea(place.getArea());
		return placeRepository.save(place1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateCity(Integer placeId, Place place)
	 - Input Parameters	:	Integer placeId, Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating city to the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public Place updateCity(Integer placeId, Place place) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place1 = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		place1.setCity(place.getCity());
		return placeRepository.save(place1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateState(Integer placeId, Place place)
	 - Input Parameters	:	Integer placeId, Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating state to the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public Place updateState(Integer placeId, Place place) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place1 = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		place1.setState(place.getState());
		return placeRepository.save(place1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updatePincode(Integer placeId, Place place)
	 - Input Parameters	:	Integer placeId, Place place
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating pincode to the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public Place updatePincode(Integer placeId, Place place) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place1 = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		place1.setPincode(place.getPincode());
		return placeRepository.save(place1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getPlaceById(Integer placeId)
	 - Input Parameters	:	Integer placeId
	 - Return Type		:	Place
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Place record from the Database based on placeId
	 ********************************************************************************************************/
	@Override
	public Place getPlaceById(Integer placeId) {
		
		if (!placeRepository.existsById(placeId)) {
			log.error("No place found with id" + placeId);
			throw new ResourceNotFoundException("No place found with id" + placeId);
		}
		
		Place place = placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Not found place with placeId " + placeId));
		return place;
	}

}
