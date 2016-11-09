package com.dh.presentation.dto;

import com.dh.dao.entities.Token;
import com.dh.dao.entities.User;
import java.util.ArrayList;
import com.dh.dao.entities.Property;

public class DreamHalt {
	
	private User user;
	
	private Token token;
	
	private Links links;
	
	private ArrayList<Property> propertyList;
	
	private String responseMessage;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public ArrayList<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	
	
	
	

}
