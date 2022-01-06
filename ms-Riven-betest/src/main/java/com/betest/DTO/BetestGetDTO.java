package com.betest.DTO;

import com.betest.entity.Betest;

public class BetestGetDTO {

	private boolean status;
	private String message;
	private Betest data;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Betest getData() {
		return data;
	}
	public void setData(Betest betest) {
		this.data = betest;
	}	
	
}
