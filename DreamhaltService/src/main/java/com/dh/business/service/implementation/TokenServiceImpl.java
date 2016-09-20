package com.dh.business.service.implementation;

import java.util.UUID;

import com.dh.business.service.interfaces.TokenServiceInterface;
import com.dh.dao.entities.Token;
import com.dh.dao.implementations.TokenDaoImpl;
import com.dh.dao.interfaces.TokenDaoInterface;

public class TokenServiceImpl implements TokenServiceInterface {
	
	TokenDaoInterface tokenDao = new TokenDaoImpl();

	@Override
	public Token generateToken(long tokenId) {
		String key = UUID.randomUUID().toString().toUpperCase();
		Token token = new Token(tokenId,key);
		return token;
	}

	@Override
	public boolean saveToken(Token token) {
		return tokenDao.insertToken(token);
	}

	@Override
	public Token validateToken(String tokenKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
