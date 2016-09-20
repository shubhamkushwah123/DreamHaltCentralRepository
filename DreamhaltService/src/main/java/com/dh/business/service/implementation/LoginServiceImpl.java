package com.dh.business.service.implementation;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;
import com.dh.dao.implementations.LoginDaoImpl;
import com.dh.dao.interfaces.LoginDaoInterface;

public class LoginServiceImpl implements LoginServiceInterface {

	LoginDaoInterface loginDao = new LoginDaoImpl();
	
	@Override
	public long verifyLogin(Login login) {
		return loginDao.verifyLogin(login);
		
	}

	@Override
	public Login forgetPassword(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login decodeCredentials(String credentials) {
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = credentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		Login login = new Login();
		
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		login.setUsername(tokenizer.nextToken());
		login.setPassword(tokenizer.nextToken());
		return login;
	}

	

}
