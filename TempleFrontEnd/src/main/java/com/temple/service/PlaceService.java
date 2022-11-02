package com.temple.service;

import java.util.List;

import com.temple.model.Place;

public interface PlaceService {

	Place addPlace(Place place);

	List<Place> getAllPlaces();

	void deletePlace(Integer placeId);

	Place updateStreet(Integer placeId, Place place);

	Place updateArea(Integer placeId, Place place);

	Place updateCity(Integer placeId, Place place);

	Place updateState(Integer placeId, Place place);

	Place updatePincode(Integer placeId, Place place);

	Place getPlaceById(Integer placeId);

}
