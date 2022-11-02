package com.temple.service;

import java.util.List;

import com.temple.model.Timings;

public interface TimingsService {

	Timings addTimings(Timings timings);

	List<Timings> getAllTimings();

	void deleteTiming(Integer timingId);

	Timings updateOpeningTime(Integer timingId, Timings timings);

	Timings updateClosingTime(Integer timingId, Timings timings);

	Timings getTimingsById(Integer timingId);

}

