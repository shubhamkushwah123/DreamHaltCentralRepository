package com.dh.business.service.implementation;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.UUID;

import com.dh.business.service.interfaces.TokenServiceInterface;
import com.dh.dao.entities.Token;
import com.dh.dao.implementations.TokenDaoImpl;
import com.dh.dao.interfaces.TokenDaoInterface;

public class TokenServiceImpl implements TokenServiceInterface {
	
	TokenDaoInterface tokenDao = new TokenDaoImpl();
	
	final long MAX_DURATION = 20*60*1000;

	@Override
	public Token generateToken(long tokenId) {
		String key = UUID.randomUUID().toString().toUpperCase() + ":" + tokenId;
		System.out.println(key);
		Token token = new Token(tokenId,key);
		return token;
	}

	@Override
	public boolean saveToken(Token token) {
		return tokenDao.insertToken(token);
	}

	@Override
	public Token validateToken(String tokenKey) {
		StringTokenizer tokenizer = new StringTokenizer(tokenKey, ":");
		String inputTokenKey = tokenizer.nextToken();
		long inputTokenId = Long.parseLong(tokenizer.nextToken());
		System.out.println(inputTokenId);
		System.out.println(inputTokenKey);
		Token token = tokenDao.retrieveToken(inputTokenId);
		long timeToExpire = new Date().getTime() - token.getCreatedAt().getTime();
		System.out.println(timeToExpire);
			if(token!=null) {
				if(token.getTokenString().toUpperCase().equalsIgnoreCase(tokenKey.toUpperCase())
					&& timeToExpire <= MAX_DURATION ) {
					System.out.println("Time difference :" + (token.getCreatedAt().getTime() - new Date().getTime()));
					return token;
				}
			}
		
		
		return null;
	}

}
