package com.dh.business.service.implementation;

import com.dh.business.service.interfaces.LoginServiceInterface;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;
import com.dh.dao.implementations.LoginDaoImpl;
import com.dh.dao.interfaces.LoginDaoInterface;

public class LoginServiceImpl implements LoginServiceInterface {

	LoginDaoInterface loginDao = new LoginDaoImpl();
	
	@Override
	public User verifyLogin(Login login) {
		return loginDao.verifyLogin(login);
		
	}

	@Override
	public Login forgetPassword(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
