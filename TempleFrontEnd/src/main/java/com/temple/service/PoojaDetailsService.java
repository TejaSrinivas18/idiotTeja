package com.temple.service;

import java.util.List;

import com.temple.model.PoojaDetails;

public interface PoojaDetailsService {

	PoojaDetails addPoojaDetails(PoojaDetails poojaDetails);

	List<PoojaDetails> getAllPoojaDetails();

	void deletePoojaDetail(Integer poojaId);

	PoojaDetails updatePoojaType(Integer poojaId, PoojaDetails poojaDetails);

	PoojaDetails updatePoojaPrice(Integer poojaId, PoojaDetails poojaDetails);

	PoojaDetails getPoojaDetailsById(Integer poojaId);

}
