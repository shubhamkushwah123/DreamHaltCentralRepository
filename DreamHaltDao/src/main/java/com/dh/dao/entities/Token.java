package com.dh.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Token {
	
	@Id
	@Column(name="token_id")
	long tokenId;
	
	@Column(name="created_at")
	Date createdAt;
	
	@Column(name="token_key")
	String tokenString;
	

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	
	public Token(long tokenId,String tokenString)
	{
		this.tokenId=tokenId;
		this.createdAt=new Date();
		this.tokenString = tokenString;
	}

	public Token() {
	}
	

}
