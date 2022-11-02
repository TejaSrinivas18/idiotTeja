package com.temple.service;

import java.util.List;

import com.temple.model.Temple;

public interface TempleService {

	Temple addTemple(Temple temple);

	List<Temple> getAllTemples();

	void deleteTemple(Integer templeId);	

	Temple retrieveTempleById(Integer templeId);

	List<Temple> retrieveTempleByName(String templeName);

	List<Temple> retrieveTemple();

	Temple updateTempleName(int templeId, Temple temple);

	Temple updateTempleHistory(int templeId, Temple temple);
	
	List<Temple> retrieveTemplesByCity(String city);

	List<Temple> retrieveTemplesByArea(String area);

	List<Temple> retrieveTemplesByState(String state);

	List<Temple> retrieveTemplesByLocation(String state, String city, String area);

}

