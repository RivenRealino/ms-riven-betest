package com.betest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betest.DTO.BetestGetDTO;
import com.betest.DTO.ObjectStatus;
import com.betest.entity.Betest;
import com.betest.helper.NowDateTimeHelper;
import com.betest.repository.BetestRepository;
import com.betest.service.BetestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BetestServiceImpl implements BetestService {
	
	@Autowired 
	BetestRepository betestRepository;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ObjectStatus create(Betest betest) {
		ObjectStatus createStatus = new ObjectStatus();
		try {
			
			ObjectStatus validateStatus = validateInput(betest);
			
			
			if (validateStatus.isStatus()) {
				List<Betest> listBetest= betestRepository.findAll();
				
				for (Betest betestPrev : listBetest) {
					if (betest.getId().equals(betestPrev.getId())) {
						createStatus.setStatus(false);
						createStatus.setMessage("Duplicate value for Id");
						return createStatus;
					}
				}
				
				betestRepository.save(betest);
				createStatus.setStatus(true);
				createStatus.setMessage("Success to create");
				return createStatus;
			} else {
				return validateStatus;
			}
		} catch (Exception e) {
			e.printStackTrace();
			createStatus.setStatus(false);
			createStatus.setMessage("Fail to create : " + e.toString());
			return createStatus;
		}
	}

	@Override
	public ObjectStatus update(Betest betest) {
		ObjectStatus createStatus = new ObjectStatus();
		try {
			
			ObjectStatus validateStatus = validateInput(betest);
			
			if (validateStatus.isStatus()) {
				Optional<Betest> betestGet = 
						betestRepository.findById(betest.getId());
				
				if (betestGet.isPresent()) {
	
					betestRepository.save(betest);
				
					createStatus.setStatus(true);
					createStatus.setMessage("Success to update");
					return createStatus;
				
				} else {
					createStatus.setStatus(false);
					createStatus.setMessage("No record");
					return createStatus;
				}
			} else {
				return validateStatus;
			}
		} catch (Exception e) {
			e.printStackTrace();
			createStatus.setStatus(false);
			createStatus.setMessage("Fail to update : " + e.toString());
			return createStatus;
		}
	}

	@Override
	public List<Betest> list() {
		return betestRepository.findAll();
	}

	@Override
	public BetestGetDTO getData(String id) {
		BetestGetDTO betestGetDTO = new BetestGetDTO();
		try {
			Optional<Betest> betestGet = 
					betestRepository.findById(id);
			
			if (betestGet.isPresent()) {
				
				betestGetDTO.setStatus(true);
				betestGetDTO.setMessage("Success to get with id : " + id);
				betestGetDTO.setData(betestGet.get());
				
				return betestGetDTO;
			} else {
				betestGetDTO.setStatus(false);
				betestGetDTO.setMessage("No Record");
				
				return betestGetDTO;
			}
		} catch (Exception e) {
			betestGetDTO.setStatus(false);
			betestGetDTO.setMessage(e.toString());
			
			return betestGetDTO;
		}
	}

	@Override
	public ObjectStatus deleteData(String id) {
		ObjectStatus deleteStatus =  new ObjectStatus();
		
		try {
			
			Optional<Betest> betestGet = 
					betestRepository.findById(id);
			
			if (betestGet.isPresent()) {
				
				betestRepository.deleteById(id);
				
				deleteStatus.setStatus(true);
				deleteStatus.setMessage("Success to delete with id : " + id);
				
				return deleteStatus;
			} else {
				deleteStatus.setStatus(false);
				deleteStatus.setMessage("No record");
				
				return deleteStatus;
			}
		} catch (Exception e) {
			e.printStackTrace();
			deleteStatus.setStatus(false);
			deleteStatus.setMessage(e.toString());
			
			return deleteStatus;
		}
	}
	
	public ObjectStatus validateInput(Betest betest) {
		
		ObjectStatus statusValidate = new ObjectStatus();
		
		List<String> errMessage = new ArrayList<String>();
		
		if (betest.getId() == null || 
				betest.getId().equals("")) {
			errMessage.add("(Recid can't be null, or empty)");
		}
		
		if (betest.getUsername() == null || 
				betest.getUsername().equals("")) {
			errMessage.add("(Username can't be null, or empty)");
		}
		
		if (betest.getAccountNumber() == null || 
				betest.getAccountNumber().equals("")) {
			errMessage.add("(Account Number can't be null, or empty)");
		}
		
		if (betest.getEmailAddress() == null || 
				betest.getEmailAddress().equals("")) {
			errMessage.add("(Email Address can't be null, or empty)");
		}
		
		if (betest.getIdentityNumber() == null || 
				betest.getIdentityNumber().equals("")) {
			errMessage.add("(Identity Number can't be null, or empty)");
		}
		
		if (errMessage.size() == 0) {
			statusValidate.setStatus(true);
		} else {
			statusValidate.setStatus(false);
			statusValidate.setMessage(String.join(",", errMessage));
		}
		return statusValidate;
	}

}
