package com.dh.dao.interfaces;

import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;

public interface LoginDaoInterface {
	
	public long verifyLogin(Login login);
	
	public Login retirevePassword(String username);

	
	
}
