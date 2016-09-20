package com.test.Service;

import com.dh.business.service.implementation.TokenServiceImpl;
import com.dh.dao.entities.Token;

public class TestService {
	
	public static void main(String args[])
	{
		String inputTokenKey="49451405-D1EA-4818-9F06-2BE671D112B2:33";
		Token token = new Token();
		TokenServiceImpl tokenService = new TokenServiceImpl();
		token = tokenService.validateToken(inputTokenKey);
		System.out.println(token.getTokenId() + "\n" + token.getTokenString() + "\n" + token.getCreatedAt());
		
		
	}

}
