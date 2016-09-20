package com.dh.business.service.interfaces;

import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;

public interface LoginServiceInterface {
	
	public long verifyLogin(Login login);
	
	public Login forgetPassword(Login login);

	public Login decodeCredentials(String credentials);

}
