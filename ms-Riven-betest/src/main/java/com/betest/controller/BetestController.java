package com.betest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betest.DTO.BetestGetDTO;
import com.betest.DTO.ObjectStatus;
import com.betest.entity.Betest;
import com.betest.service.BetestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(path = "betestAPI")
public class BetestController {

	@Autowired
	BetestService atiUploadFileParamService;
	
	@Autowired
	ObjectMapper mapper;
	
	@PostMapping("/Create")
	public ObjectStatus createATIUploadFileParam(@RequestBody Betest Betest) {
		return atiUploadFileParamService.create(Betest);
	}
	
	@PostMapping("/Update")
	public ObjectStatus updateATIUploadFileParam(@RequestBody  Betest antasenaBaseCurrency) {
		return atiUploadFileParamService.update(antasenaBaseCurrency);
	}
	
	@GetMapping("/List")
	public List<Betest> listATIUploadFileParam() {
		return atiUploadFileParamService.list();
	}
	
	@GetMapping("/Get")
	public BetestGetDTO listATIUploadFileParam(@RequestParam String id) {
		return atiUploadFileParamService.getData(id);
	}
	
	@DeleteMapping("/Delete")
	public ObjectStatus deleteATIUploadFileParam(@RequestParam String id) {
		return atiUploadFileParamService.deleteData(id);
	}
}
