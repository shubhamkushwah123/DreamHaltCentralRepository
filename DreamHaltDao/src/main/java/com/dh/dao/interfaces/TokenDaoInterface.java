package com.dh.dao.interfaces;

import com.dh.dao.entities.Token;

public interface TokenDaoInterface {

	public boolean insertToken(Token token);
	
	public Token retrieveToken(long tokenId);

}
