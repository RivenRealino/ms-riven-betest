package com.betest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "[account]")//DEFINE TABLE NAME IN DB
public class Betest {
	
	@Id
	@Column(name = "ID",nullable = false)
	private String id;
	
	@Column(name = "USERNAME",nullable = false)
	private String username;
	
	@Column(name = "ACCOUNT_NUMBER",nullable = false)
	private String accountNumber;
	
	@Column(name = "EMAIL_ADDRESS",nullable = true)
	private String emailAddress;
	
	@Column(name = "IDENTITY_NUMBER",nullable = false)
	private String identityNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	
}
