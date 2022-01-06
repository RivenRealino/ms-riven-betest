package com.betest.service;

import java.util.List;

import com.betest.DTO.BetestGetDTO;
import com.betest.DTO.ObjectStatus;
import com.betest.entity.Betest;

public interface BetestService {
	
	ObjectStatus create(Betest betest);
	
	ObjectStatus update(Betest betest);
	
	List<Betest> list();
	
	BetestGetDTO getData(String id);
	
	ObjectStatus deleteData(String id);

}
