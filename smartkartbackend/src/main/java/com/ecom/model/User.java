package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User
{
	@Id
	 
	private String userEmailId;
	String userPassword;
	String userName;
	String userContact;
	String userAddress;
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String uerEmailId) {
		this.userEmailId = uerEmailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContact() {
		return userContact;
	}
	public void setContact(String contact) {
		this.userContact = contact;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



}