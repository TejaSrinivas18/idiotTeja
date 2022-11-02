package com.temple.service;

import java.util.List;

import com.temple.model.Festival;

public interface FestivalService {

	Festival addFestival(Festival festival);

	List<Festival> getAllFestivals();

	void deleteFestival(Integer festivalId);

	Festival updateFestivalName(Integer festivalId, Festival festival);

	Festival updateFestivalDate(Integer festivalId, Festival festival);

	Festival updateFestivalStartTime(Integer festivalId, Festival festival);

	Festival updateFestivalEndTime(Integer festivalId, Festival festival);

	Festival getFestivalById(Integer festivalId);

}