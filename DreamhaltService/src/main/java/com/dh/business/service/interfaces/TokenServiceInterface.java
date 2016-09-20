package com.dh.business.service.interfaces;

import com.dh.dao.entities.Token;

public interface TokenServiceInterface {

	public Token generateToken(long tokenId);

	public boolean saveToken(Token token);
	
	public Token validateToken(String tokenKey);

}
