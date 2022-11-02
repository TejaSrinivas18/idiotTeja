package com.temple.service;

import java.util.List;

import com.temple.model.DevoteeFunds;

public interface DevoteeFundsService {

	DevoteeFunds addDevoteeFunds(DevoteeFunds devoteeFunds);

	List<DevoteeFunds> getAllDevotees();

	void deleteDevotee(Integer devoteeId);

	DevoteeFunds updateDevoteeName(Integer devoteeId, DevoteeFunds devotee);

	DevoteeFunds updateDevoteeAmount(Integer devoteeId, DevoteeFunds devotee);

	DevoteeFunds updateDevoteeMobileNumber(Integer devoteeId, DevoteeFunds devotee);

	DevoteeFunds getDevoteeById(Integer devoteeId);

	DevoteeFunds updateDevoteeEmail(Integer devoteeId, DevoteeFunds devotee);

}
