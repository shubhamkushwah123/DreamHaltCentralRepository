package com.dh.presentation.dto;

import com.dh.dao.entities.Token;
import com.dh.dao.entities.User;

public class HomeScreenDTO {
	
	LinkDTO linkDTO;
	
	User user;
	
	Token token;


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

	public LinkDTO getLinkDTO() {
		return linkDTO;
	}

	public void setLinkDTO(LinkDTO linkDTO) {
		this.linkDTO = linkDTO;
	}

	
}
